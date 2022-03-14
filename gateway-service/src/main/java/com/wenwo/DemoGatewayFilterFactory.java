package com.wenwo;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class DemoGatewayFilterFactory extends
        AbstractGatewayFilterFactory<DemoGatewayFilterFactory.DemoConfig> {

    public static final String NAME_KEY="name";

    public DemoGatewayFilterFactory() {
        super(DemoConfig.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(NAME_KEY);
    }

    @Override
    public GatewayFilter apply(DemoConfig config) {
        return (exchange, chain) -> {
            System.out.println("[Pre] 请求被拦截:"+config.getName());
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                System.out.println("[Post] Response  Filter");
            }));
        };
    }

    public static class DemoConfig {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

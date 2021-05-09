package com.atjiuhua.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myself {
    @Bean
    public IRule myRule(){
        //负载均衡随机性能
        return new RandomRule();
    }
}

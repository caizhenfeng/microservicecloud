package com.atguigu.springcloud.cfgbeans;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
@Configuration
public class ConfigBean
{
    @Bean
    @LoadBalanced//负载均衡开始注解
    public RestTemplate getRestTemplate()
    {
         return new RestTemplate();
    }

}


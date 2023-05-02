package com.example.corsplugindemo.config;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.example.corsplugindemo.Properties.CorsProperties;
import com.example.corsplugindemo.service.CorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaoying
 * @create 2023/4/20 16:18
 */
@Configuration
@EnableConfigurationProperties({CorsProperties.class})
@ConditionalOnClass(CorsService.class)
@ConditionalOnProperty(prefix = "web.cors", value = "enabled", havingValue = "true")
public class AutoConfig {

    @Autowired
    private CorsProperties corsProperties;

    @Bean
    @ConditionalOnMissingBean(CorsService.class)
    public CorsService corsService(){
        return new CorsService(corsProperties);
    }

}

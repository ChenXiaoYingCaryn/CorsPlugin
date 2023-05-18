package com.example.corsplugindemo.config;

import com.example.corsplugindemo.Properties.CorsProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.sql.SQLOutput;

/**
 * @author xiaoying
 * @create 2023/4/20 16:18
 */
@Configuration
@EnableConfigurationProperties(CorsProperties.class)
@ConditionalOnClass(AutoConfig.class)
@ConditionalOnProperty(prefix = "web.cors", value = "enabled", matchIfMissing = true)
public class AutoConfig {

    @Autowired
    private CorsProperties corsProperties;

    public CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(corsProperties.getAllowedOrigins()); // 1允许域名使用
        corsConfiguration.setAllowedHeaders(corsProperties.getAllowedHeaders()); // 2允许头
        corsConfiguration.setAllowedMethods(corsProperties.getAllowedMethods()); // 3允许方法（post、get等）
        corsConfiguration.setAllowCredentials(corsProperties.isAllowCredentials()); // 4允许cookies跨域
        return corsConfiguration;
    }

    @Bean
    public UrlBasedCorsConfigurationSource configurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return source;
    }

}

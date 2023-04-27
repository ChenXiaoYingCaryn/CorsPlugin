package com.example.corsplugindemo.service;

import com.example.corsplugindemo.Properties.CorsProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author xiaoying
 * @create 2023/4/20 16:19
 */
public class CorsService {

    private CorsProperties corsProperties;

    public CorsService() {
    }

    public CorsService(CorsProperties corsProperties) {
        this.corsProperties = corsProperties;
    }

    private CorsConfiguration buildConfig() {
        System.out.println("go into build config");
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(corsProperties.getAllowedOrigins()); // 1允许域名使用
        System.out.println("allowed origins " + corsConfiguration.getAllowedOrigins().toString());
        corsConfiguration.setAllowedHeaders(corsProperties.getAllowedHeaders()); // 2允许头
        corsConfiguration.setAllowedMethods(corsProperties.getAllowedMethods()); // 3允许方法（post、get等）
        corsConfiguration.setAllowCredentials(corsProperties.isAllowCredentials()); // 4允许cookies跨域
        return corsConfiguration;
    }

    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new CorsFilter(source));
        // 设置 Filter 的优先级为最高优先级(如果有多个过滤器这些过滤器会有一个先后顺序的问题)
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filterRegistrationBean;
    }
}

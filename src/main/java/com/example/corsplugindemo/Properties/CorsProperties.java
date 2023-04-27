package com.example.corsplugindemo.Properties;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author xiaoying
 * @create 2023/4/20 15:12
 */
@Data
@ConfigurationProperties(prefix = "web.cors")
public class CorsProperties {

//    @NacosValue("${web.cors.enabled}")
    private boolean enabled;

//    @NacosValue("${web.cors.allowed-origins}")
    private List<String> allowedOrigins;

//    @NacosValue("${web.cors.allowed-methods}")
    private List<String> allowedMethods;

//    @NacosValue("${web.cors.allowed-headers}")
    private List<String> allowedHeaders;

//    @NacosValue("${web.cors.allowed-headers}")
    private List<String> exposedHeaders;

//    @NacosValue("${web.cors.allowed-credentials}")
    private boolean allowCredentials;

//    @NacosValue("${web.cors.max-age}")
    private long maxAge;

}

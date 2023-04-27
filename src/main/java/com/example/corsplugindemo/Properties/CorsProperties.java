package com.example.corsplugindemo.Properties;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.List;

/**
 * @author xiaoying
 * @create 2023/4/20 15:12
 */
@Data
@ConfigurationProperties(prefix = "web.cors")
@NacosConfigurationProperties(prefix = "web.cors", dataId = "SpringSecurityDemo.application.properties", type = ConfigType.PROPERTIES, autoRefreshed = true)
public class CorsProperties {

    private boolean enabled;

    private List<String> allowedOrigins;

    private List<String> allowedMethods;

    private List<String> allowedHeaders;

    private List<String> exposedHeaders;

    private boolean allowCredentials;

    private long maxAge;

}

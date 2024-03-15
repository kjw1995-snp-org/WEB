package com.snp.web.configuration.properties.base;

import com.snp.web.configuration.properties.factory.YamlPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:config/properties/base-properties.yaml", factory = YamlPropertySourceFactory.class)
@Data
@ConfigurationProperties("base")
public class BaseProperties {

    private BaseUserService baseUserService;

}

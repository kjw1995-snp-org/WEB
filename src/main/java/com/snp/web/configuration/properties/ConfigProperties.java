package com.snp.web.configuration.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Getter
@ConfigurationProperties("com.snp")
@RefreshScope
public class ConfigProperties {
}

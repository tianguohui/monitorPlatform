package com.ph.monitorPlatform.utils.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "config.jwt")
@Component

public class JwtParam {
    private String secret;
    private long expire;
    private String header;

}

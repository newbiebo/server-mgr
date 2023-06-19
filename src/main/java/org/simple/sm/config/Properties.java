package org.simple.sm.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Properties {

    @Value("${env.bark.server.url}")
    private String barkServerUrl;

}

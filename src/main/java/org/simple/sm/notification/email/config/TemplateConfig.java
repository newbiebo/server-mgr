package org.simple.sm.notification.email.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 邮件模版配置类
 */
@Data
@Component
public class TemplateConfig {

    @Value("${velocity.vm.name}")
    private String velocityTemplateName ;

    @Value("${thymeleaf.html.name}")
    private String thymeleafTemplateName;

}

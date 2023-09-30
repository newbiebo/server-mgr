package org.simple.sm.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger2.ui.enable}")
    private boolean displaySwitch;
    @Value("${server.port}")
    private String serverPort;
    @Value("${env.servermgr.version}")
    private String version;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public Docket createRestApi() {
        if (displaySwitch) logger.info("doc url:http://localhost:{}/server-mgr/swagger-ui.html",serverPort);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //Is it enabled (true to enable false to hide. It is recommended to hide in production environments)
                .enable(displaySwitch)
                .select()
                //Scan the path package and set the base package to use all methods of @ Api marked classes under the package as APIs
                .apis(RequestHandlerSelectors.basePackage("org.simple.sm"))
                //Specify path processing Path Selectors. any() to represent all paths
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //Set Document Title (API Name)
                .title("server-mgr interface specification")
                //document description
                .description("interface description")
                //Service Terms URL
                .termsOfServiceUrl("http://localhost:"+serverPort+"/")
                //version number
                .version(version)
                .build();
    }
}

package org.simple.sm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author newbiebo
 */
@Configuration
@ServletComponentScan
@SpringBootApplication
@MapperScan("org/simple/sm/db/sqlite/mapper")
public class ServerManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerManagerApplication.class, args);
        System.out.println("------ServerManagerApplication Is Runing------");
    }

}

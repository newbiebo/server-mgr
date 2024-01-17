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
@MapperScan("org.simple.sm.db.sqlite.mapper")
public class ServerManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerManagerApplication.class, args);
        System.out.println(
                "      __                                  _   _             \n" +
                "    /    )                                /  /|             \n" +
                "----\\--------__---)__---------__---)__---/| /-|----__---)__-\n" +
                "     \\     /___) /   ) | /  /___) /   ) / |/  |  /   ) /   )\n" +
                "_(____/___(___ _/______|/__(___ _/_____/__/___|_(___/_/_____\n" +
                "                                                   /        \n" +
                "                                               (_ / ");
    }

}

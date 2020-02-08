package com.dairy;

import com.dairy.configuration.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class DairyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DairyApplication.class, args);
    }

}

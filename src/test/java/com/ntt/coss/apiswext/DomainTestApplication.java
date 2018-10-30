package com.ntt.coss.apiswext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import com.eai.common.config.DozerConfig;

@SpringBootApplication
//@ContextConfiguration(locations = {"classpath*:/**/*mapper.xml"})
@ComponentScan(basePackages = {"com.eai.*"})
@Import({DozerConfig.class})
public class DomainTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomainTestApplication.class, args);

    }

}
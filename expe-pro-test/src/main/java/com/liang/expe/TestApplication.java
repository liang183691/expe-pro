package com.liang.expe;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationPid;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("com.liang.expe.*.*.mapper")
@SpringBootApplication
@Slf4j
public class TestApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .sources(TestApplication.class)
                .main(TestApplication.class)
                .run(args);
        log.info("----TestApplication Start PID={}----", new ApplicationPid().toString());
        context.registerShutdownHook();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}


package com.gaethering.moduleuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
    scanBasePackages = {"com.gaethering.modulecommon", "com.gaethering.moduleuser"}
)
@EntityScan("com.gaethering.modulecommon.domain")
@EnableJpaRepositories(basePackages = "com.gaethering.modulecommon.repository")
@EnableJpaAuditing
public class ModuleUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleUserApplication.class, args);
    }

}

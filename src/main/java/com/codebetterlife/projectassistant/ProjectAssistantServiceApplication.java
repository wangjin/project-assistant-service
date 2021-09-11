package com.codebetterlife.projectassistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-01 7:24 下午
 */
@EnableJpaRepositories
@SpringBootApplication
public class ProjectAssistantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectAssistantServiceApplication.class, args);
    }

}

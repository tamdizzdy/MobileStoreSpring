package com.wfh.mobilestorespring;

import com.wfh.mobilestorespring.model.User;
import com.wfh.mobilestorespring.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MobileStoreSpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MobileStoreSpringApplication.class, args);

    }

}

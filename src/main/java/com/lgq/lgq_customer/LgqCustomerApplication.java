package com.lgq.lgq_customer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.lgq.lgq_customer.mapper")
@SpringBootApplication
public class LgqCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LgqCustomerApplication.class, args);
    }

}

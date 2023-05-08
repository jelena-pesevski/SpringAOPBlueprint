package com.example.aop;

import com.example.aop.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

  public static void main(String[] args) {
    SpringApplication.run(AopApplication.class, args);
  }

  @Bean
  Employee getEmployee() {
    final var emp = new Employee();
    emp.setName("Jelena");
    return emp;
  }

}

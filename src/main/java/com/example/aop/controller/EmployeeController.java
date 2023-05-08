package com.example.aop.controller;

import com.example.aop.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping
  public String get(){
    employeeService.getEmployee().setName("Jane");
    return employeeService.getEmployee().getName();
  }

  @GetMapping("/exception")
  public void throwException(){
    employeeService.getEmployee().throwException();
  }
}

package com.example.aop.service;

import com.example.aop.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired
  private Employee employee;

  public Employee getEmployee() {
    return this.employee;
  }

}

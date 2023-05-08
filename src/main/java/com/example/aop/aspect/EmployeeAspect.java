package com.example.aop.aspect;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class EmployeeAspect {

  @Before("execution(public String getName())")
  public void getNameAdvice() {
    log.info("Executing advice before getName");
  }

  @Before("execution(* com.example.aop.service.*.get*())")
  public void getAllAdvice() {
    log.info("Service method getter called");
  }

  @Pointcut("execution(public String getName())")
  public void getNamePointcut() {
  }

  @Before("getNamePointcut()")
  public void secondAdvice() {
    log.info("Executing advice before getNamePointcut advice");
  }

  @Before("execution(public void com.example.aop.model..set*(*))")
  public void loggingAdvice(JoinPoint joinPoint) {
    System.out.println("Before running loggingAdvice on method=" + joinPoint.toString());

    System.out.println("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));
  }

//  @After("args(name)")
//  public void logStringArguments(String name){
//    System.out.println("Running After Advice. String argument passed="+name);
//  }

  @AfterThrowing("within(com.example.aop.model.Employee)")
  public void logExceptions(JoinPoint joinPoint) {
    System.out.println("Exception thrown in Employee Method=" + joinPoint.toString());
  }

  @AfterReturning(pointcut = "execution(* getName())", returning = "returnString")
  public void getNameReturningAdvice(String returnString) {
    System.out.println("getNameReturningAdvice executed. Returned String=" + returnString);
  }


}

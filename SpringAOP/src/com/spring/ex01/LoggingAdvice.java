package com.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//Advice class
public class LoggingAdvice implements MethodInterceptor{

   @Override
   public Object invoke(MethodInvocation invocation) throws Throwable {
      // 메서드 호출 전에 수행
      System.out.println("메서드 호출 전 : LoggingAdvice");
      System.out.println(invocation.getMethod() + " => 메서드 호출 전");
      //메서드 호출
      Object obj=invocation.proceed(); //타겟의 메서드 수행
      //메서드 호출 후에 수행
      System.out.println("메서드 호출 후 : LoggingAdvice");
      System.out.println(invocation.getMethod() + " => 메서드 호출 후");
      return obj;
   }
}
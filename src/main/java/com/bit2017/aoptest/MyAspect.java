package com.bit2017.aoptest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before("execution(ProductVo com.bit2017.aoptest.ProductService.find(..))")
	public void before(){
		System.out.println("call [before advice]");
	}
	@After("execution(* *..aoptest.ProductService.find(..))")
	public void after(){
		System.out.println("call [after advice]");
	}
	
	@Around("execution(* *..*.ProductService.*(..))")
	public ProductVo around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("call [around advice: before]");
		
		Object[] a = {"camera"};
		ProductVo vo = (ProductVo) pjp.proceed(a);
		
		System.out.println("call [around advice: after]");
		
		return vo;
	}
	@AfterReturning(value="execution(* *..*.ProductService.find(..))", returning="vo")
	public void afterReturning(ProductVo vo){
		System.out.println("call [afterreturning advice]"+vo);
	}
	@AfterThrowing(value="execution(* *..*.ProductService.find(..))", throwing="vo")
	public void afterThrowing(Throwable ex){
		System.out.println("call [afterThrowing advice"+ex);
	}
}

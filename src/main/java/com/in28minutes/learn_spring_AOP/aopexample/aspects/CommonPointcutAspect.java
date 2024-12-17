package com.in28minutes.learn_spring_AOP.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutAspect {
	@Pointcut("execution(* com.in28minutes.learn_spring_AOP.aopexample.*.*.*(..))")
	public void businessAndDataPackageConfig() {}
	
	@Pointcut("execution(* com.in28minutes.learn_spring_AOP.aopexample.business.*.*(..))")
	public void businessPackageConfig() {}
	
	@Pointcut("execution(* com.in28minutes.learn_spring_AOP.aopexample.data.*.*(..))")
	public void dataPackageConfig() {}
	
	@Pointcut("bean(*dataService*)")
	public void dataServiceConfig() {}
}

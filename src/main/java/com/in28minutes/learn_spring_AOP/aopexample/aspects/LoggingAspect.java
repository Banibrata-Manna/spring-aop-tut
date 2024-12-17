package com.in28minutes.learn_spring_AOP.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Before("com.in28minutes.learn_spring_AOP.aopexample.aspects.CommonPointcutAspect.dataServiceConfig()") // When?
	public void logMethodCallBefore(JoinPoint joinPoint) {
		// Logic - What?
		logger.info("Before Aspect - {} Method is called with Args : {}", joinPoint, joinPoint.getArgs());
	}
	
	@After("com.in28minutes.learn_spring_AOP.aopexample.aspects.CommonPointcutAspect.dataPackageConfig()") // When?
	public void logMethodCallAfter(JoinPoint joinPoint) {
		// Logic - What?
		logger.info("After Aspect - {} Method is called", joinPoint);
	}
	
	@AfterThrowing(pointcut = "com.in28minutes.learn_spring_AOP.aopexample.aspects.CommonPointcutAspect.businessAndDataPackageConfig()",
			throwing = "exception"
			) // When?
	public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
		// Logic - What?
		logger.info("After throwing Aspect - {} Method is thrown exception - {}", joinPoint, exception);
	}
	
	@AfterReturning(pointcut = "com.in28minutes.learn_spring_AOP.aopexample.aspects.CommonPointcutAspect.businessAndDataPackageConfig()",
			returning = "resultValue"
			) // When?
	public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
		// Logic - What?
		logger.info("After returning Aspect - {} Method has given resulValue - {}", joinPoint, resultValue);
	}
}

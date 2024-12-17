package com.in28minutes.learn_spring_AOP.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
//	@Around("com.in28minutes.learn_spring_AOP.aopexample.aspects.CommonPointcutAspect.businessAndDataPackageConfig()")
	@Around("@annotation(com.in28minutes.learn_spring_AOP.aopexample.annotations.TrackTime)")
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		long currentTimeMillis = System.currentTimeMillis();
		
		Object returnValue = proceedingJoinPoint.proceed();
		
		long stopTimeMillis = System.currentTimeMillis();
		
		long executionTimeMillis = stopTimeMillis - currentTimeMillis;
		
		logger.info("Around Aspect - {} Method executed in {} ms", proceedingJoinPoint, executionTimeMillis);
		
		return returnValue;
		
	}
}

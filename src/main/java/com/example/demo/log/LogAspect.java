package com.example.demo.log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect 
{
	public static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);
	
	@Before("execution(public * com.example.demo.AlienController.aliens())")
	public void logBefore()
	{
		LOGGER.info("You have learned AOP(Aspect Orinted Programming) Log method called..!!");
	}
	
	@AfterReturning("execution(public * com.example.demo.AlienController.aliens())")
	public void logAfter()
	{
	LOGGER.info("Aliens Fetched Successfully");
	}
	
	@AfterThrowing("execution(public * com.example.demo.AlienController.aliens())")
	public void logError()
	{
	LOGGER.info("Error");
	}
}

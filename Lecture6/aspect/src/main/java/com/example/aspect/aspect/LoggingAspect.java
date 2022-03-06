package com.example.aspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author D0Loop
 * @since 2022-03-06 [2022.3월.06]
 */

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around(value = "@annotation(LogExecutionTime)") // pointcut
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // advice
        long startTime = System.currentTimeMillis();

        Object proceed = proceedingJoinPoint.proceed();

        long execTime = System.currentTimeMillis() - startTime;
        logger.trace("method executed in {}", execTime);

        return proceed;

    }

    @Before(value = "@annotation(LogArguments)")
    public void logParameters(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.trace("method description: {}", methodSignature.getMethod());
        logger.trace("method name: {}",  methodSignature.getName());
        logger.trace("declaring class: {}", methodSignature.getDeclaringType());

        Object[] arguments = joinPoint.getArgs();
        if(arguments.length == 0) {
            logger.trace("No arguments");
        }
        for (Object argument : arguments) {
            logger.trace("argument: {}", argument);
        }
    }

    @AfterReturning(value = "@annotation(LogResult)", returning = "returnValue")
    public void logResults(JoinPoint joinPoint, Object returnValue) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.trace("method name: {}", methodSignature.getMethod());
        logger.trace("return type: {}",  methodSignature.getReturnType());
        logger.trace("return value: {}", returnValue);
    }
}

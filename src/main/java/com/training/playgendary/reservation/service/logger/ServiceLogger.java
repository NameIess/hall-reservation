package com.training.playgendary.reservation.service.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

/**
 * Contains methods-advices for the service layer methods logging automation.
 */
@Aspect
public class ServiceLogger {
    private static final Logger Log = LogManager.getLogger(ServiceLogger.class.getSimpleName());

    /**
     * Writes info log before the method execution where the method name satisfies particular pattern.
     *
     * @param joinPoint Well-defined point in the execution of a program - Method call
     */
    @Before("execution(* com.training.playgendary.reservation.service.impl.*ServiceImpl.*(..))")
    public void logBeforeExecution(JoinPoint joinPoint) {
        Log.info("Method has been called : " + joinPoint.getSignature().getName());
        Log.info("Transferred parameters : " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * Writes info log after returning the method execution result where the method name satisfies particular pattern.
     *
     * @param joinPoint Well-defined point in the execution of a program - Method execution
     * @param result    Value that has been returned by particular method.
     */
    @AfterReturning(
            pointcut = "execution(* com.training.playgendary.reservation.service.impl.*ServiceImpl.*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        Log.info("Executed method : " + joinPoint.getSignature().getName());
        Log.info("Transferred parameters : " + Arrays.toString(joinPoint.getArgs()));
        Log.info("Method returned value is : " + result);
    }

    /**
     * Writes error log after throwing exception while method execution where the method name satisfies particular pattern.
     *
     * @param joinPoint Well-defined point in the execution of a program - Method execution
     * @param error     Error object that has been thrown while method execution/
     */
    @AfterThrowing(
            pointcut = "execution(* com.training.playgendary.reservation.service.impl.*ServiceImpl.*(..))",
            throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        Log.error("Exception during method execution!");
        Log.error("Exception has been thrown within method : " + joinPoint.getSignature().getName());
        Log.error("Exception name : " + error);
        Log.error("Exception message : " + error.getMessage());
    }
}

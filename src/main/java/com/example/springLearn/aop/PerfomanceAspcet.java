package com.example.springLearn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.thymeleaf.util.DateUtils;

import java.util.Date;
import java.util.Locale;

/**
 * @author liuji
 * @create 2019-05-05 16:26
 */
@Aspect
public class PerfomanceAspcet {

    @Pointcut("execution(public void *.request()) && @within(com.example.springLearn.aop.JoinpointAnnotation) && @annotation(com.example.springLearn.aop.JoinpointAnnotation1)")
    public void pointcutName() {

    }

    @Around("pointcutName()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("around start===>" + DateUtils.format(new Date(), Locale.CHINESE));
        try {
            return joinPoint.proceed();
        } finally {
            System.out.println("around end===>" + DateUtils.format(new Date(), Locale.CHINESE));
        }

    }
}

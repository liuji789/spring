package com.example.springLearn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

    @Pointcut("execution(public void *.request(String,Integer)) && args(param1,param2)")
    public void argesPointCut(String param1,Integer param2){

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


    @Before(value = "argesPointCut(param1,param2)")
    public void before(String param1,Integer param2){
        System.out.println("Before requestParam = " + param1 + param2);
    }

    @Before(value ="execution(public void *.request()) && @within(com.example.springLearn.aop.JoinpointAnnotation) && @annotation(com.example.springLearn.aop.JoinpointAnnotation1) && @annotation(joinpointAnnotation1)" )
    public void beforeParam(JoinpointAnnotation1 joinpointAnnotation1){
        System.out.println("joinpointAnnotation1.annotatiaonParam() = " + joinpointAnnotation1.annotatiaonParam());
    }
}

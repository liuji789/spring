package com.example.springLearn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.thymeleaf.util.DateUtils;

import java.util.Date;
import java.util.Locale;

/**
 * @author liuji
 * @create 2019-05-05 16:26
 */
@Aspect
@Order(2)
public class PerfomanceAspcet implements Ordered {

    @Pointcut("execution(public void *.request()) && @within(com.example.springLearn.aop.JoinpointAnnotation) && @annotation(com.example.springLearn.aop.JoinpointAnnotation1)")
    public void pointcutName() {

    }

    @DeclareParents(value = "com.example.springLearn.aop.Requestable",defaultImpl = RequestableImpl.class)
    public IRequestable requestable;

    @Pointcut("execution(public void *.request(String,Integer)) && args(param1,param2)")
    public void argesPointCut(String param1,Integer param2){

    }
    @Pointcut("execution(public void *.method1())")
    public void method1(){

    }

    @Pointcut("execution(public void *.method2())")
    public void method2(){

    }

    @Around("method1() || method2()")
    public Object method1And2(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("around start===>" + DateUtils.format(new Date(), Locale.CHINESE));
        try {
            return joinPoint.proceed();
        } finally {
            System.out.println("around end===>" + DateUtils.format(new Date(), Locale.CHINESE));
        }

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

    @Override
    public int getOrder() {
        return 100;
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

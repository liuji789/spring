package com.example.springLearn.aop;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @author liuji
 * @create 2019-04-18 14:09
 */
public class Spring {
    public static void main(String[] args) {

        RequestableImpl requestable = new RequestableImpl();
        ServiceControlRequestableProxy proxy = new ServiceControlRequestableProxy(requestable);

        proxy.request();

        Class<?>[] interfaces = requestable.getClass().getInterfaces();

        //动态生成动态代理类对象
        //第一个参数：类加载器对象
        //第二个参数：目标对象所实现的接口
        //第个参数：告知代理类使用哪个代理模板，即代理处理器
        IRequestable iRequestable = (IRequestable) Proxy.newProxyInstance(Spring.class.getClassLoader(), interfaces, new RequestCtrlInvocationHandler(new RequestableImpl()));

        iRequestable.request();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Requestable.class);
        enhancer.setCallback(new RequestCtrlCallback());

        Requestable requestable1 = (Requestable) enhancer.create();
        requestable1.request();

    }

    @Test
    public void testProxyFactory() throws Exception {
        RequestableImpl requestable = new RequestableImpl();
        ProxyFactory weave = new ProxyFactory(requestable);

        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        PerfomanceMethodInterceptor advice = new PerfomanceMethodInterceptor();
        advisor.setMappedName("request");
        advisor.setAdvice(advice);

        //可以去掉，默认动态代理方式
        weave.setInterfaces(requestable.getClass().getInterfaces());
        //weave.setProxyTargetClass(true);
        weave.addAdvisor(advisor);
        IRequestable proxy = (IRequestable) weave.getProxy();

        proxy.request();
        System.out.println("proxy.getClass() = " + proxy.getClass());

        ProxyFactory proxyFactory = new ProxyFactory(new Requestable());
        proxyFactory.addAdvisor(advisor);

        Requestable weaveProxy = (Requestable) proxyFactory.getProxy();
        weaveProxy.request();
        System.out.println("weaveProxy.getClass() = " + weaveProxy.getClass());
    }

    @Test
    public void testTargetSource() throws Exception {
        IRequestable requestableOne = () -> System.out.println("requestableOne = " + true);
        IRequestable requestableTwo = () -> System.out.println("requestableTwo = " + true);

        ProxyFactory proxyFactory = new ProxyFactory();
        AlternativeTargetSource targetSource = new AlternativeTargetSource(requestableOne, requestableTwo);
        proxyFactory.setTargetSource(targetSource);

        IRequestable requestable = (IRequestable) proxyFactory.getProxy();

        requestable.request();
        requestable.request();
        requestable.request();
        requestable.request();
        requestable.request();


    }

    @Test
    public void testAspect() throws Exception {
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(new WithinRequest());

        proxyFactory.addAspect(PerfomanceAspcet.class);

        Object proxy = proxyFactory.getProxy();

        ((IRequestable) proxy).request();
        ((IRequestable) proxy).request();
    }

    @Test
    public void testAspectParam() throws Exception {
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(new WithinRequestParam());

        proxyFactory.addAspect(PerfomanceAspcet.class);

        Object proxy = proxyFactory.getProxy();

        ((IRequestableParan) proxy).request("param111",2);
        ((IRequestableParan) proxy).request("param1",22);
    }
}

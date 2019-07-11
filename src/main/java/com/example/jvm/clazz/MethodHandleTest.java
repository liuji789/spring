package com.example.jvm.clazz;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author liuji
 * @create 2019-06-28 15:47
 */
public class MethodHandleTest {

    static class ClassA{
        public void println(String s){
            System.out.println("classA---->"+s);
        }
    }

    public static void main(String[] args) throws Throwable {

        for (int i = 0; i < 10; i++) {
            Object o = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();

            getPrintMH(o).invokeExact("ajaksks");
        }

    }

    private static MethodHandle getPrintMH(Object reveiver) throws NoSuchMethodException, IllegalAccessException {
        MethodType methodType = MethodType.methodType(void.class, String.class);

        return MethodHandles.lookup().findVirtual(reveiver.getClass(),"println",methodType).bindTo(reveiver);

    }
}

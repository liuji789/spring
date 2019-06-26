package com.example.jvm.clazz;

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };
        Object loadClass = classLoader.loadClass("com.example.jvm.clazz.ClassLoaderTest");
        System.out.println("loadClass.getClass() = " + loadClass.getClass());
        System.out.println("loadClass instanceof ClassLoaderTest = " + (loadClass instanceof ClassLoaderTest));
    }
}

package com.example.jvm.clazz;

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }

            /**
             * 双亲委派模型，你需要告诉怎么find你需要的class
             * @param name
             * @return
             * @throws ClassNotFoundException
             */
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                return super.findClass(name);
            }
        };
        Object loadClass = classLoader.loadClass("com.example.jvm.clazz.ClassLoaderTest");
        System.out.println("loadClass.getClass() = " + loadClass.getClass());
        System.out.println("loadClass instanceof ClassLoaderTest = " + (loadClass instanceof ClassLoaderTest));
    }


}

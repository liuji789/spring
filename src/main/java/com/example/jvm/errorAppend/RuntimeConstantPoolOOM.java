package com.example.jvm.errorAppend;


/**
 * 运行时常量池内存溢出异常
 * 1.6及之前可以，后来永久代改了，常量池不需要设置参数
 * --XX:PermSize=10M --XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOM {


    public static void main(String[] args) {



//        ArrayList<String> strings = new ArrayList<>();
//
//        int i = 0;
//
//        while (true){
//            strings.add(String.valueOf(i++).intern());
//        }

        /**
         * jdk 1.7之后，intern不在复制实例，常量池中记录首次出现的实例引用
         * 计算机软件 首先出现在java堆上 首次出现 intern 返回引用 java不是首次出现，地址不一样
         */
        String string1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(string1.intern() == string1);

        String string2 = new StringBuilder("ja").append("va").toString();
        System.out.println(string2.intern() == string2);

    }
}

package com.java11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @Author: Ma HaiYang
 * @Description: MircoMessage:Mark_7001
 */
public class Demo2 {
    public void testx(){
        // 传统的 try catch finally语句块
        InputStreamReader isr =null;
        try{
            isr =new InputStreamReader(new FileInputStream("d:/aaa.txt"));
            isr.read();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != isr){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // JAVA8 try语法升级
    public void testa(){
        // JAVA8 try catch finally语句块
        try( InputStreamReader isr =new InputStreamReader(new FileInputStream("d:/aaa.txt"));){
            isr.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // JAVA9 try语法升级
    public void testb() throws FileNotFoundException {
        // JAVA9 try catch finally语句块
        InputStreamReader isr =new InputStreamReader(new FileInputStream("d:/aaa.txt"));
        OutputStreamWriter isw =new OutputStreamWriter(new FileOutputStream("d:/aaa.txt"));
        try( isr; isw){
            isr.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
package com.example.jvm.errorAppend;

import java.util.HashMap;
import java.util.WeakHashMap;

public class refTest {


    public static void main(String[] args) {
        hashMapGc();

        System.out.println("--------------------------------------------------------------------------------------------------");

        weakHashMapGc();
    }

    private static void weakHashMapGc() {
        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();

        Integer key1 = new Integer(1);
        String value="value2";

        String key2 = new String("1");
        String key3 = "key3";


        weakHashMap.put(key1,value);
        weakHashMap.put(key2,value);
        weakHashMap.put(key3,value);


        key1 = null;
        key2 = null;
        key3 = null;

        System.out.println("weakHashMap = " + weakHashMap);

        System.gc();

        System.out.println("weakHashMap = " + weakHashMap);
    }

    private static void hashMapGc() {

        HashMap<String, String> hashMap = new HashMap<>();

        String key ="key";
        String value="value";

        hashMap.put(key,value);

        key = null;

        System.gc();

        System.out.println("hashMap = " + hashMap);

    }

}

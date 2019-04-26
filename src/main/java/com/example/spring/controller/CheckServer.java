package com.example.spring.controller;

import com.example.spring.service.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuji
 * @create 2019-04-17 16:31
 */
@RestController
public class CheckServer {

    @Autowired
    private AService aService;

    @RequestMapping("/check")
    public Map<String, Object> spring() {
        HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("code", "1");
        returnMap.put("msg", "11111111");
        return returnMap;
    }

    @RequestMapping("/test")
    public Map<String, Object> test() throws Exception{

        new Thread() {
            @Override
            public void run() {
                Integer a = null;
                try {
                    a = aService.getA("1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("1:a = " + a);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                Integer a = null;
                try {
                    a = aService.getA("2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("2:a = " + a);
            }
        }.start();
        Thread.sleep(10000);
        HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("code", "1");
        returnMap.put("msg", "11111111");
        return returnMap;
    }

}

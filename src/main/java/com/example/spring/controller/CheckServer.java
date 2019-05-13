package com.example.spring.controller;

import com.example.spring.bean.AAAA;
import com.example.spring.service.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuji
 * @create 2019-04-17 16:31
 */
@Controller
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

    @RequestMapping("/thymeleaf")
    public String thymeleaf(@RequestParam(name = "file", required = false) MultipartFile file,String username) {
        if (file != null) {

            System.out.println("file.getSize() = " + file.getSize());
        }
        System.out.println("username = " + username);
        return "redirect:thymeleafOK";
    }
    @RequestMapping("/thymeleafOK")
    public String toThymeleafOk() {
        return "thymeleafOK";
    }


    @RequestMapping("/toThymeleaf")
    public String toThymeleaf() {
        return "thymeleaf";
    }

    @RequestMapping("/test")
    public Map<String, Object> test() throws Exception{

        new Thread() {
            @Override
            public void run() {
                AAAA a = null;
                AAAA a1 = null;
                try {
                    a = getaService().getA("1");
                    a1 = aService.getA("1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("1:a = " + a.getA()+";;;"+a1.getA());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                AAAA a = null;
                try {
                    a = getaService().getA("2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("2:a = " + a.getA());
            }
        }.start();
        Thread.sleep(10000);
        HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("code", "1");
        returnMap.put("msg", "11111111");
        return returnMap;
    }

    @Lookup("aService")
    public AService getaService(){
        return null;
    }



}

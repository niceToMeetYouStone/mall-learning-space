package com.wang.mall.tiny.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("admin")
public class LoginController {



    @PostMapping("login")
    public void testMain(){
        System.out.println("====================");
    }
}

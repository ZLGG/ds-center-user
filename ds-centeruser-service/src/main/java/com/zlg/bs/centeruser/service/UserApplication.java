package com.zlg.bs.centeruser.service;

import com.zlg.bs.center.user.util.VerifyCodeUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(UserApplication.class, args);
        VerifyCodeUtils.test();
        System.out.println("success");
    }
}

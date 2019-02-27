package com.zlg.bs.centeruser.service;

import com.zlg.bs.center.user.eo.UserEo;
import com.zlg.bs.center.user.util.VerifyCodeUtils;
import com.zlg.bs.centeruser.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping("get")
public class Controller {
    @Autowired
    UserServiceImpl userService;
    @RequestMapping("/test1")
    public String test() {
        return userService.selectUserById(1).toString();
    }

    @RequestMapping("/test2")
    public String test1() {
        return userService.selectUser(new UserEo()).toString();
    }

    @RequestMapping("/test3")
    public String test2(UserEo userEo) {
        userEo.setAccountId(13454647879L);
        userService.insertUser(userEo);
        return "success";
    }

    @RequestMapping("/test4")
    public void verifyCode(HttpServletResponse response) throws Exception{
        ServletOutputStream outputStream = response.getOutputStream();
        String s = VerifyCodeUtils.generateVerifyCode(4);
        VerifyCodeUtils.outputImage(200, 80, outputStream, s);
    }
}

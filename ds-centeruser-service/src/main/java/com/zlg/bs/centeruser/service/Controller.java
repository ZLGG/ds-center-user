package com.zlg.bs.centeruser.service;

import com.zlg.bs.center.user.eo.UserEo;
import com.zlg.bs.centeruser.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

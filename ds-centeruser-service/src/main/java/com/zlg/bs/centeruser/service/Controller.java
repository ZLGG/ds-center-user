package com.zlg.bs.centeruser.service;

import com.zlg.bs.center.user.api.UserApi;
import com.zlg.bs.center.user.eo.UserEo;
import com.zlg.bs.center.user.util.VerifyCodeUtils;
import com.zlg.bs.center.user.vo.ResponseDto;
import com.zlg.bs.centeruser.service.apiImpl.UserApiImpl;
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
    @Autowired
    UserApi userApi;

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
        userEo.setAccountId("1231");
        userService.insertUser(userEo);
        return "success";
    }

    @RequestMapping("/test4")
    public void verifyCode(HttpServletResponse response) throws Exception {
        ServletOutputStream outputStream = response.getOutputStream();
        String s = VerifyCodeUtils.generateVerifyCode(4);
        VerifyCodeUtils.outputImage(200, 80, outputStream, s);
    }
    @RequestMapping("/test6")
    public ResponseDto test6(int id) {
        ResponseDto<UserEo> userEoResponseDto = userApi.selectUserById(id);
        return userEoResponseDto;
    }
    @RequestMapping("/test7")
    public ResponseDto test7(UserEo userEo) {
        ResponseDto userEoResponseDto = userApi.selectUser(userEo);
        return userEoResponseDto;
    }
    @RequestMapping("/test8")
    public ResponseDto test8(UserEo userEo) {
        ResponseDto<UserEo> userEoResponseDto = userApi.insertUser(userEo);
        return userEoResponseDto;
    }
    @RequestMapping("/test9")
    public ResponseDto test9(Long id) {
        ResponseDto<UserEo> userEoResponseDto = userApi.activationUser(id);
        return userEoResponseDto;
    }
    @RequestMapping("/test10")
    public ResponseDto test10(UserEo userEo) {
        ResponseDto<UserEo> userEoResponseDto = userApi.login(userEo);
        return userEoResponseDto;
    }
    @RequestMapping("/test11")
    public ResponseDto test11(Long id) {
        ResponseDto userEoResponseDto = userApi.deleteUser(id);
        return userEoResponseDto;
    }

}

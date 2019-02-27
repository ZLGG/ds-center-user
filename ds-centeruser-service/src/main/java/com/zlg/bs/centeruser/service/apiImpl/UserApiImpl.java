package com.zlg.bs.centeruser.service.apiImpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.zlg.bs.center.user.api.UserApi;
import com.zlg.bs.center.user.eo.UserEo;
import com.zlg.bs.centeruser.service.service.UserService;
import com.zlg.bs.centeruser.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

@Service(group = "zlg",version = "0.0.1")
public class UserApiImpl implements UserApi {


    @Autowired
    UserService userService;
    public UserEo selectUserById(int i) {
        UserEo userEo = userService.selectUserById(1);
        return userEo;
    }

    public List<UserEo> selectUser(UserEo userEo) {
        List<UserEo> userEos = null;
        if (userEo != null) {
            userEos = userService.selectUser(userEo);
        }

        return userEos;
    }

    public String insertUser(UserEo userEo) {
        UserEo userEo1 = new UserEo();
        userEo1.setMobile(userEo.getMobile());
        List<UserEo> userEos = userService.selectUser(userEo1);
        if (userEos == null) {
            String s = userService.insertUser(userEo);
            return s;
        }
        return "error";
    }

    public String activationUser(Long aLong) {
        UserEo userEo = new UserEo();
        userEo.setId(aLong);
        List<UserEo> userEos = userService.selectUser(userEo);
        if (userEos == null) {
            //用户不存在
            return "error";
        }
        userEo.setStatus(1);
        List<UserEo> userEos1 =userService.selectUser(userEo);
        if (userEos1 != null) {
            //已经激活
            return "already";
        }
        String s = userService.activationUser(userEo);
        return s;
    }

    public UserEo login(UserEo userEo) {
        return null;
    }

    public String deleteUser(Long aLong) {
        return null;
    }
}

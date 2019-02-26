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
}

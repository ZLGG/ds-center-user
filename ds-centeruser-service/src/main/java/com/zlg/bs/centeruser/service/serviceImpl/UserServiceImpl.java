package com.zlg.bs.centeruser.service.serviceImpl;

import com.zlg.bs.center.user.eo.UserEo;
import com.zlg.bs.centeruser.service.mapper.UserMapper;
import com.zlg.bs.centeruser.service.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    public UserEo selectUserById(int id) {
        UserEo userEo = userMapper.selectUserById(id);
        return userEo;
    }

    public List<UserEo> selectUser(UserEo userEo) {
        userEo.setMobile("17633901170");
        List<UserEo> userEos = userMapper.selectUser(userEo);
        return userEos;
    }
}

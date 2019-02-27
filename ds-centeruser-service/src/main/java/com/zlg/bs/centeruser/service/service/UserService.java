package com.zlg.bs.centeruser.service.service;

import com.zlg.bs.center.user.eo.UserEo;

import java.util.List;

public interface UserService {
    UserEo selectUserById(int id);

    List<UserEo> selectUser(UserEo userEo);

    UserEo insertUser(UserEo userEo);

    String activationUser(UserEo userEo)throws Exception;

    void deleteUser(UserEo userEo);
}

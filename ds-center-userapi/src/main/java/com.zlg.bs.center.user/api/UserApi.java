package com.zlg.bs.center.user.api;

import com.zlg.bs.center.user.eo.UserEo;

import java.util.List;

public interface UserApi {
    UserEo selectUserById(int id);

    List<UserEo> selectUser(UserEo userEo);
}

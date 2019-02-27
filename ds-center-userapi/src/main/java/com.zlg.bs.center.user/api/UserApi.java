package com.zlg.bs.center.user.api;

import com.zlg.bs.center.user.eo.UserEo;

import java.util.List;

public interface UserApi {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    UserEo selectUserById(int id);

    /**
     * 根据条件查找用户
     * @param userEo
     * @return
     */
    List<UserEo> selectUser(UserEo userEo);

    /**
     * 注册用户
     * @param userEo
     * @return error失败 success成功
     */
    public String insertUser(UserEo userEo);

    /**
     * 激活用户
     * @param id
     * @return error失败 success成功
     */
    public String activationUser(Long id);

    /**
     * 登录
     * @param userEo
     * @return
     */
    public UserEo login(UserEo userEo);

    /**
     * 注销账户
     * @param id
     * @return
     */
    public String deleteUser(Long id);

    public void verifyCode( );
}

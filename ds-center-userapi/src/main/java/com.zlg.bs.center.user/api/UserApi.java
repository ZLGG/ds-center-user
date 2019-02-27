package com.zlg.bs.center.user.api;

import com.zlg.bs.center.user.eo.UserEo;
import com.zlg.bs.center.user.vo.ResponseDto;

import java.util.List;

public interface UserApi {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    ResponseDto<UserEo> selectUserById(int id);

    /**
     * 根据条件查找用户
     * @param userEo
     * @return
     */
    ResponseDto<List<UserEo>> selectUser(UserEo userEo);

    /**
     * 注册用户
     * @param userEo
     * @return error失败 success成功
     */
    public ResponseDto<UserEo> insertUser(UserEo userEo);

    /**
     * 激活用户
     * @param id
     * @return error失败 success成功
     */
    public ResponseDto<UserEo> activationUser(Long id);

    /**
     * 登录
     * @param userEo
     * @return
     */
    public ResponseDto<UserEo> login(UserEo userEo);

    /**
     * 注销账户
     * @param id
     * @return
     */
    public ResponseDto deleteUser(Long id);

}

package com.zlg.bs.centeruser.service.apiImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zlg.bs.center.user.api.UserApi;
import com.zlg.bs.center.user.eo.UserEo;
import com.zlg.bs.center.user.vo.ResponseDto;
import com.zlg.bs.centeruser.service.service.UserService;
import com.zlg.bs.centeruser.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

@Service(group = "zlg",version = "0.0.1")
public class UserApiImpl implements UserApi {


    @Resource
    UserService userService;
    public ResponseDto<UserEo> selectUserById(int id) {
        UserEo userEo = userService.selectUserById(id);
        return new ResponseDto<UserEo>(userEo);
    }



    public ResponseDto<List<UserEo>> selectUser(UserEo userEo) {
        List<UserEo> userEos = null;
        if (userEo != null) {
            userEos = userService.selectUser(userEo);
        }

        return new ResponseDto<List<UserEo>>(userEos);
    }

    public ResponseDto<UserEo> insertUser(UserEo userEo) {
        UserEo userEo1 = new UserEo();
        userEo1.setMobile(userEo.getMobile());
        List<UserEo> userEos = userService.selectUser(userEo1);
        if (userEos.size() == 0) {
            UserEo userEo2 = userService.insertUser(userEo);
            return new ResponseDto<UserEo>(userEo2);
        }
        return new ResponseDto<UserEo>(ResponseDto.RESULT_FAIL, null, null, "用户已存在");
    }

    public ResponseDto<UserEo> activationUser(Long aLong) {
        UserEo userEo = new UserEo();
        userEo.setId(aLong);
        List<UserEo> userEos = userService.selectUser(userEo);
        if (userEos == null) {
            //用户不存在
            return new ResponseDto<UserEo>(ResponseDto.RESULT_FAIL, null, null, "用户不存在");
        }
        userEo.setStatus(1);
        List<UserEo> userEos1 =userService.selectUser(userEo);
        if (userEos1.size() != 0) {
            //已经激活
            return new ResponseDto<UserEo>(ResponseDto.RESULT_FAIL, null, null, "已经激活");
        }
        try {
            userService.activationUser(userEo);
        } catch (Exception e) {
            return new ResponseDto<UserEo>(ResponseDto.RESULT_FAIL, null, null, e.getMessage());
        }
        return new ResponseDto<UserEo>(ResponseDto.RESULT_SUCCESS,"激活成功");
    }

    public ResponseDto<UserEo> login(UserEo userEo) {
        if (userEo == null) {
            return new ResponseDto<UserEo>(ResponseDto.RESULT_FAIL, "数据为空");
        }
        List<UserEo> userEos = userService.selectUser(userEo);
        if (userEos != null && userEos.size() == 1) {
            return new ResponseDto<UserEo>(userEos.get(0));
        }
        UserEo userEo1 = new UserEo();
        userEo1.setMobile(userEo.getMobile());
        List<UserEo> userEos1 = userService.selectUser(userEo1);
        if (userEos1.size() == 0) {
            return new ResponseDto<UserEo>(ResponseDto.RESULT_FAIL, "账号错误");
        }
        userEo1.setPassword(userEo.getPassword());
        List<UserEo> userEos2 = userService.selectUser(userEo1);
        if (userEos2.size() == 0) {
            return new ResponseDto<UserEo>(ResponseDto.RESULT_FAIL,"密码错误");
        }
        return new ResponseDto<UserEo>(ResponseDto.RESULT_FAIL, "未激活");
    }

    public ResponseDto deleteUser(Long aLong) {
        UserEo userEo = new UserEo();
        userEo.setDr(1);
        userEo.setId(aLong);
        userService.deleteUser(userEo);
        return new ResponseDto("注销成功");
    }
}

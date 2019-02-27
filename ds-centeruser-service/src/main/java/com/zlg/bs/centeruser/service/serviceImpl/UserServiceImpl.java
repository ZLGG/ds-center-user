package com.zlg.bs.centeruser.service.serviceImpl;

import com.zlg.bs.center.user.eo.UserEo;
import com.zlg.bs.centeruser.service.exception.UserException;
import com.zlg.bs.centeruser.service.mapper.UserMapper;
import com.zlg.bs.centeruser.service.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
        List<UserEo> userEos = userMapper.selectUser(userEo);
        return userEos;
    }

    public UserEo insertUser(UserEo userEo) {
        if (userEo != null) {
            userMapper.insertUser(userEo);
            List<UserEo> userEos = userMapper.selectUser(userEo);
            if (userEos != null && userEos.size() == 1) {
                UserEo userEo1 = userEos.get(0);
                return userEo1;
            }
        }
        return null;
    }

    public String activationUser(UserEo userEo) throws Exception{
        if (userEo != null) {
            try {
                userMapper.updateUser(userEo);

            } catch (Exception e) {
                throw new UserException("激活失败");
            }
            return "success";
        }
        throw new UserException("数据为空");
    }

    public void deleteUser(UserEo userEo) {
        if (userEo != null&&userEo.getId()!=null) {
            userMapper.deleteUser(userEo.getId());
        }
    }
}

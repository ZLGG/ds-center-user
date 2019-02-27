package com.zlg.bs.centeruser.service.mapper;

import com.zlg.bs.center.user.eo.UserEo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("select * from mc_account where dr = 0 and id = #{id}")
    UserEo selectUserById( int id);
    @Select("<script>" +
            "select * from mc_account where dr = 0" +
            "<if test = 'eo.id != null'> and mc_account.id = #{eo.id} </if>" +
            "<if test = 'eo.accountId != null'> and mc_account.account_id = #{eo.accountId}</if>" +
            "<if test = 'eo.nickName != null'> and mc_account.nick_name Like concat('%',#{eo.nickName},'%') </if>" +
            "<if test = 'eo.mobile != null'> and mc_account.mobile = #{eo.mobile} </if>" +
            "<if test = 'eo.email != null'> and mc_account.email = #{eo.email} </if>" +
            "order by mc_account.id desc" +
            "</script>")
    List<UserEo> selectUser(@Param("eo") UserEo eo);

    @Insert("insert into mc_account (account_id , nick_name , mobile ,email , password , create_time) values (#{eo.accountId},#{eo.nickName},#{eo.mobile},#{eo.email},#{eo.password},now())")
    void insertUser(@Param("eo") UserEo eo);

    @Update("update mc_account set" +
            "<if test = 'eo.nickName != null'> mc_account.nick_name = #{eo.nickName},</if>" +
            "<if test = 'eo.mobile != null '> mc_account.mobile = #{eo.mobile},</if>" +
            "<if test = 'eo.email != null '> mc_account.email = #{eo.email},</if>" +
            "<if test = 'eo.password != null'> mc_account.password = #{eo.password},</if>" +
            "<if test = 'eo.status != null'> mc_account.status = #{eo.status},</if>" +
            "mc_account.update_time = now()" +
            "where mc_account.id = #{eo.id}")
    void updateUser(@Param("eo") UserEo eo);

    @Update("update mc_account set mc_account.dr = 1")
    void deleteUser(int id);
}

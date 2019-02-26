package com.zlg.bs.center.user.eo;



import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Time;
@Data
@Table
public class UserEo implements Serializable {
    private Long id;
    private Long accountId;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "account_id")
    private String mobile;
    private String email;
    private String password;

    private Integer status;
    @Column(name = "create_time")
    private String createTime;
    @Column(name = "update_time")
    private String updateTime;
    private Integer dr;


}

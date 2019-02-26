package com.zlg.bs.centeruser.service.config.bean;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
@Data
public class DataSourceVo implements Serializable {
    private String driverClassName;
    private String jdbcUrl;
    private String jdbcUserName;
    private String jdbcUserPassword;
    private String validationQuery;
    private int initialSize;
    private int maxActive;
    private int minIdle;
    private int maxWait;


}

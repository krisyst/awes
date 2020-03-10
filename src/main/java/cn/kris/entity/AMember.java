package cn.kris.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AMember {

    private long id;
    private String username;
    private String password;
    private Integer status;
    private Date createDate;
}

package cn.kris.entity;

import lombok.Data;

import java.util.Date;

@Data
public class APicture {

    private long id;
    private String name;
    private String oldName;
    private String memberId;
    private Integer status;
    private Date createDate;
}

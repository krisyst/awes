package cn.kris.entity;

import lombok.Data;

@Data
public class SAuth {

    private Integer id;
    private String name;
    private String password;
    private Integer parentId;

}

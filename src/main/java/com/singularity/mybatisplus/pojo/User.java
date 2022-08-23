package com.singularity.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.singularity.mybatisplus.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Singularity
 * @Date: 2022/8/22 12:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName(value = "t_user")//设置实体类对应的表名
public class User {

    //将属性所对应的字段指定为主键
    //@TableId注解的value属于用于指定主键的字段
    //@TableId注解的Type属性用于设置主键的生成策略
    @TableId(value = "uid")
    private Long id;

    @TableField(value = "user_name")
    private String name;

    private Integer age;

    private String email;

    @TableField(value = "sex")
    private SexEnum sexEnum;

    //逻辑删除
    @TableLogic
    private Integer isDeleted;

    public User(String userName,Integer age,String email){
        this.name = userName;
        this.age = age;
        this.email = email;
    }

    public User(String userName,String email){
        this.name = userName;
        this.email = email;
    }


    public User(String userName,Integer age,SexEnum sexEnum){
        this.name = userName;
        this.age = age;
        this.sexEnum = sexEnum;
    }


}

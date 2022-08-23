package com.singularity.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: Singularity
 * @Date: 2022/8/23 10:22
 */
@AllArgsConstructor
@Getter
public enum SexEnum {

    MALE(1,"男"),

    FEMALE(0,"女");

    @EnumValue //将注解所标识的属性的值存储到数据库中
    private Integer sex;

    private String name;


}

package com.singularity.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: Singularity
 * @Date: 2022/8/23 9:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;

    private String name;

    private BigDecimal price;

    @Version//标识乐观锁版本号
    private Integer version;
}

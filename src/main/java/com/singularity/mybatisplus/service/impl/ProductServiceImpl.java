package com.singularity.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.singularity.mybatisplus.mapper.ProductMapper;
import com.singularity.mybatisplus.pojo.Product;
import com.singularity.mybatisplus.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @Author: Singularity
 * @Date: 2022/8/23 11:07
 */
@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}

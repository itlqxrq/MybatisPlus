package com.singularity.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.singularity.mybatisplus.mapper.UserMapper;
import com.singularity.mybatisplus.pojo.User;
import com.singularity.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: Singularity
 * @Date: 2022/8/22 14:10
 */
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

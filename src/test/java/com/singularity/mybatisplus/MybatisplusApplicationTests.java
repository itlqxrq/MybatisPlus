package com.singularity.mybatisplus;

import com.singularity.mybatisplus.mapper.UserMapper;
import com.singularity.mybatisplus.pojo.User;
import com.singularity.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void insert(){
        //新增
//        userMapper.insert(new User("Janice",23,"janice@singularity.com"));

        // 通过Id删除用户信息
//        System.out.println(userMapper.deleteById(1561582210845384706L));

        //通过Map集合删除
//        Map<String,Object> map=new HashMap<>();
//        map.put("name","Janice");
//        map.put("age",23);
//        System.out.println(userMapper.deleteByMap(map));

        //通过多个id批量删除
//        System.out.println(userMapper.deleteBatchIds(Arrays.asList(1L, 2L, 3L)));

        //根据id进行修改
//        System.out.println(userMapper.updateById(new User(4L, "Janice", 18, "Janice@qq.com")));

        //根据单个id查询用户信息
//        System.out.println(userMapper.selectById(1L));

        //根据多个id进行用户信息
//       userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L)).forEach(System.out::println);

        //根据map集合中条件进行查询
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","jack");
//        map.put("age",20);
//        userMapper.selectByMap(map).forEach(System.out::println);

        //自定义查询功能
//        System.out.println(userMapper.selectMapById(1L));
    }


    @Autowired
    private UserService userService;

    @Test
    void test(){
        //查询总记录数
//        System.out.println(userService.count());

        //批量添加
//        List<User> list = new ArrayList<>();
//        for (int i = 1; i <=10 ; i++) {
//            User user = new User();
//            user.setName("singularity"+i);
//            user.setAge(20+i);
//            list.add(user);
//        }
//        System.out.println(userService.saveBatch(list));

    }

}

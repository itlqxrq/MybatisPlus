package com.singularity.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.singularity.mybatisplus.enums.SexEnum;
import com.singularity.mybatisplus.mapper.ProductMapper;
import com.singularity.mybatisplus.mapper.UserMapper;
import com.singularity.mybatisplus.pojo.Product;
import com.singularity.mybatisplus.pojo.User;
import com.singularity.mybatisplus.service.ProductService;
import com.singularity.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: Singularity
 * @Date: 2022/8/22 15:37
 */
@SpringBootTest
public class MybatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void  test(){
        //查询用户名包含a,年龄在20-30之间并且邮箱不为null的用户信息
//        userMapper.selectList(new QueryWrapper<User>()
//                .like("user_name","a")
//                .between("age",20,30)
//                .isNotNull("email")).forEach(System.out::println);

        //查询用户信息,按照年龄的降序进行排序，如果年龄相同则按照id的升序进行排序
//        userMapper.selectList(new QueryWrapper<User>()
//                .orderByDesc("age")
//                .orderByAsc("uid")).forEach(System.out::println);

        //删除邮箱信息为null的用户数据
//        userMapper.delete(new QueryWrapper<User>().isNull("email"));

        //将(年龄大于20并且用户名包含a)或者邮箱为null的用户信息修改

        userMapper.update(new User("Janice","Janice@qq.com"),
                new QueryWrapper<User>()
                .gt("age",20)
                .like("user_name","a")
                .or().isNull("email"));
    }

    @Test
    void test1(){

        //将用户名中包含有a并且(年龄大于20或者邮箱为null)的用户信息修改
        //lambda中的条件优先执行
//        userMapper.update(new User("Singularity","Singularity@qq.com"),
//                new QueryWrapper<User>()
//                        .like("user_name","a")
//                        .and(it -> it.gt("age","20")
//                                .or().isNull("email")));

        //根据条件进行查询
        userMapper.selectMaps(new QueryWrapper<User>()
                .select("user_name","age","email")).forEach(System.out::println);
    }

    @Test
    void test2(){
        //子查询id小于等于4的用户信息
//        userMapper.selectList(new QueryWrapper<User>()
//                .inSql("uid","SELECT uid FROM t_user WHERE uid <= 4"))
//                .forEach(System.out::println);

        //将用户名中包含有a并且(年龄大于20或者邮箱为null)的用户信息修改
        userMapper.update(null,new UpdateWrapper<User>().like("user_name","a")
                .and(it -> it.gt("age","20").or().isNull("email"))
                .set("user_name","xiaohei")
                .set("email","adc@qq.com"));

    }
    @Test
    void test3(){

        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)) {
            //isNotBlank判断某个字符串是否不为空字符串,不为null，不为空白符
           wrapper.like("user_name",username);
        }
        if (ageBegin !=null){
            wrapper.ge("age",ageBegin);
        }
        if (ageEnd !=null){
            wrapper.le("age",ageEnd);
        }
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void test4(){
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;


//        userMapper.selectList(new QueryWrapper<User>()
//                .like(StringUtils.isNotBlank(username),"user_name",username)
//                .ge(ageBegin != null,"age",ageBegin)//小于
//                .le(ageEnd != null,"age",ageEnd)).forEach(System.out::println);//大于


//        userMapper.selectList(new LambdaQueryWrapper<User>()
//                .like(StringUtils.isNotBlank(username),User::getName,username)
//                .ge(ageBegin != null,User::getAge,ageBegin)
//                .le(ageEnd != null,User::getAge,ageEnd)).forEach(System.out::println);

        //将用户名中包含有a并且(年龄大于20或者邮箱为null)的用户信息修改
        userMapper.update(null,new LambdaUpdateWrapper<User>().like(User::getName,"a")
                .and(it -> it.gt(User::getAge,"20").or().isNull(User::getEmail))
                .set(User::getName,"xiaoming")
                .set(User::getEmail,"xiaoming@qq.com"));
    }

    @Test
    void test5(){
//        System.out.println(userMapper.selectPage(new Page<>(2, 3),
//                null));

        Page<User> userPage = userMapper.selectPage(new Page<>(2, 3),
                null);

        //打印信息
        System.out.println(userPage.getRecords());
        System.out.println(userPage.getPages());
        System.out.println(userPage.getTotal());
        //是否有下一页
        System.out.println(userPage.hasNext());
        //是否有上一页
        System.out.println(userPage.hasPrevious());

    }

    @Test
    void test6(){

        Page<User> pageVo = userMapper.selectPageVo(new Page<User>(1, 3), 20);
        //打印信息
        System.out.println(pageVo.getRecords());
        System.out.println(pageVo.getPages());
        System.out.println(pageVo.getTotal());
        //是否有下一页
        System.out.println(pageVo.hasNext());
        //是否有上一页
        System.out.println(pageVo.hasPrevious());
    }

    @Autowired
    private ProductMapper productMapper;

    @Test
    void test7(){
        //小李查询商品价格
        Product productLi = productMapper.selectById(1L);
        System.out.println("小李查询的商品价格:"+productLi.getPrice());

        //小王查询商品价格
        Product productWang = productMapper.selectById(1L);
        System.out.println("小王查询的商品价格:"+productWang.getPrice());

        //小李将商品价格加50
        productLi.setPrice(productLi.getPrice().add(new BigDecimal(50)));
        productMapper.updateById(productLi);

        //小王将商品价格减去30
        productWang.setPrice(productWang.getPrice().subtract(new BigDecimal(30)));
        int result = productMapper.updateById(productWang);
        if (result == 0) {
            //操作失败,重试
            Product productNew = productMapper.selectById(1L);
            productNew.setPrice(productNew.getPrice().subtract(new BigDecimal(30)));
            productMapper.updateById(productNew);
        }

        //老板查询商品价格
        Product productLaoBan = productMapper.selectById(1L);
        System.out.println("老板查询的商品价格:"+productLaoBan.getPrice());

    }

    @Test
    void test8(){
//        userMapper.insert(new User("admin",33, SexEnum.MALE));

        userMapper.selectList(new QueryWrapper<User>()
                .eq("user_name","admin"))
                .forEach(System.out::println);
    }

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Test
    void test9(){
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
    }
}

package com.bwie.zjh.demo;

import com.alibaba.fastjson.JSON;
import com.bwie.zjh.mapper.UserMapper;
import com.bwie.zjh.mapper.orderMapper;
import com.bwie.zjh.pojo.Order;
import com.bwie.zjh.pojo.Users;
import org.hibernate.type.OrderedMapType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserMapper mapper;


    @Autowired
    private orderMapper o;
    @Test
    public void show1(){
        Optional<Users> byId = mapper.findById(1L);
        System.out.println(JSON.toJSONString(byId.get().getList().get(0).getUsers()));
    }

    @Test
    public void save(){
        for (int i=0;i<=5;i++){
            Users users = new Users();
            users.setName("张三");
            users.setGender("男");
            users.setBirthday(new Date());
            users.setDescs("sssssss");
            users.setIsa(1L);
            users.setUsername("123123");
            users.setPassword("132342");
            users.setZhu("zzzzzzzzzz");
            Users users1 = mapper.saveAndFlush(users);
            System.out.println(users1);
        }
    }

    @Test
    public void saveOrder(){
        Order order = new Order();
        order.setIso(1L);
        order.setMoney("1231");
        order.setOrdern(123L);
        order.setOrderTime(new Date());

        Users all = mapper.findAll().get(0);
        order.setUser_id(all.getId());

        o.save(order);
    }

    @Test
    public void test2(){
        Users byId = mapper.findById(1L).get();
        byId.setIsa(0L);
        List<Order> list = byId.getList();
        list.forEach(entity->{
            entity.setIso(0L);
        });
        mapper.saveAndFlush(byId);
    }

    @Test
    public void show2(){
        Calendar instance = Calendar.getInstance();
        instance.set(2019,12,26,15,8,8);

        List<Order> byOrderTime = o.findByOrderTime(instance.getTime());
        System.out.println(JSON.toJSONString(byOrderTime));
    }
}

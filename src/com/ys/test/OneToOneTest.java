package com.ys.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.ys.one2one.mapper.OrdersMapper;
import com.ys.po.Orders;
import com.ys.po.User;
import com.ys.po.UserVo;

public class OneToOneTest {
	//定义 SqlSession
    SqlSession session =null;
     
    @Before
    public void init(){
        //定义mybatis全局配置文件
        String resource = "mybatis-configuration.xml";
        //加载 mybatis 全局配置文件
        InputStream inputStream = OneToOneTest.class.getClassLoader()
                                    .getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //根据 sqlSessionFactory 产生 session
        session = sessionFactory.openSession();
    }
    
    @Test
    public void testSelectOrderAndUserByOrderId(){
        String statement = "com.ys.one2one.mapper.OrdersMapper.selectOrderAndUserByOrderID";
        //创建OrdersMapper对象，mybatis自动生成mapepr代理对象
        OrdersMapper orderMapper = session.getMapper(OrdersMapper.class);
        Orders order = orderMapper.selectOrderAndUserByOrderID(1);
        System.out.println(order);
        session.close();
    }
}

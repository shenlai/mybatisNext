package com.ys.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ys.lazyload.mapper.LazyLoadOrdersMapper;
import com.ys.one2many.mapper.NewUserMapper;
import com.ys.po.Orders;
import com.ys.po.User;

public class LazyLoadTest {
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
    public void testLazy(){
        //String statement = "com.ys.lazyload.OrdersMapper.getOrderByOrderId";
        //创建OrdersMapper对象，mybatis自动生成mapepr代理对象
    	LazyLoadOrdersMapper orderMapper = session.getMapper(LazyLoadOrdersMapper.class);
        List<Orders> orders = orderMapper.getOrderByOrderId();//第一步 不执行
        for(Orders order : orders){//执行getOrderByOrderId
            System.out.println(order.getUser());//第二步  //执行getUserByUserId
        }
        session.close();
    }
}

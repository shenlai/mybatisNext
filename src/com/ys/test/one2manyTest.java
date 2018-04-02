package com.ys.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ys.one2many.mapper.NewUserMapper;
import com.ys.po.User;

public class one2manyTest {
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
        //String statement = "com.ys.one2many.mapper.NewUserMapper.selectUserAndOrdersByUserId";
        //创建OrdersMapper对象，mybatis自动生成mapepr代理对象
        NewUserMapper newUserMapper = session.getMapper(NewUserMapper.class);
        User user = newUserMapper.selectUserAndOrdersByUserId(1);
        System.out.println(user.getOrders().size());
        session.close();
    }
}

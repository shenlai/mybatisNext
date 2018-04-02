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
	//���� SqlSession
    SqlSession session =null;
     
    @Before
    public void init(){
        //����mybatisȫ�������ļ�
        String resource = "mybatis-configuration.xml";
        //���� mybatis ȫ�������ļ�
        InputStream inputStream = OneToOneTest.class.getClassLoader()
                                    .getResourceAsStream(resource);
        //����sqlSession�Ĺ���
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //���� sqlSessionFactory ���� session
        session = sessionFactory.openSession();
    }
    
    @Test
    public void testSelectOrderAndUserByOrderId(){
        String statement = "com.ys.one2one.mapper.OrdersMapper.selectOrderAndUserByOrderID";
        //����OrdersMapper����mybatis�Զ�����mapepr�������
        OrdersMapper orderMapper = session.getMapper(OrdersMapper.class);
        Orders order = orderMapper.selectOrderAndUserByOrderID(1);
        System.out.println(order);
        session.close();
    }
}

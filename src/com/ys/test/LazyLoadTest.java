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
    public void testLazy(){
        //String statement = "com.ys.lazyload.OrdersMapper.getOrderByOrderId";
        //����OrdersMapper����mybatis�Զ�����mapepr�������
    	LazyLoadOrdersMapper orderMapper = session.getMapper(LazyLoadOrdersMapper.class);
        List<Orders> orders = orderMapper.getOrderByOrderId();//��һ�� ��ִ��
        for(Orders order : orders){//ִ��getOrderByOrderId
            System.out.println(order.getUser());//�ڶ���  //ִ��getUserByUserId
        }
        session.close();
    }
}

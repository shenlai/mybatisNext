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
        //String statement = "com.ys.one2many.mapper.NewUserMapper.selectUserAndOrdersByUserId";
        //����OrdersMapper����mybatis�Զ�����mapepr�������
        NewUserMapper newUserMapper = session.getMapper(NewUserMapper.class);
        User user = newUserMapper.selectUserAndOrdersByUserId(1);
        System.out.println(user.getOrders().size());
        session.close();
    }
}

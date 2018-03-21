package com.ys.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ys.annocation.ProductMapper;
import com.ys.annocation.UserMapper;
import com.ys.po.Product;
import com.ys.po.User;

public class UserMapperTestClient {
	//����SqlSession
			SqlSession session =null;
			
			@Before
			public void init() throws IOException {
				//����mabatisȫ�������ļ�
				String resource = "mybatis-configuration.xml";
				
				//����mybatisȫ�������ļ�
				//InputStream inputStream = TestClient.class.getClassLoader().getResourceAsStream(resource);
				
				InputStream inputStream = Resources.getResourceAsStream(resource);
				SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
				SqlSessionFactory factory = builder.build(inputStream);
				//����sqlSessionFactory����session
				session = factory.openSession();	
			}
			
			
		    @Test
		    public void testSelectUserById() throws Exception{
		    
		    	//����session��ȡMapper�ӿ�
		    	UserMapper mapper =session.getMapper(UserMapper.class);
		    	
		    	User user =mapper.selectUserById(1);
		   
		        System.out.println(user);
		        session.close();
		    }
}

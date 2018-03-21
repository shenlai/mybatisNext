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
	//定义SqlSession
			SqlSession session =null;
			
			@Before
			public void init() throws IOException {
				//定义mabatis全局配置文件
				String resource = "mybatis-configuration.xml";
				
				//加载mybatis全局配置文件
				//InputStream inputStream = TestClient.class.getClassLoader().getResourceAsStream(resource);
				
				InputStream inputStream = Resources.getResourceAsStream(resource);
				SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
				SqlSessionFactory factory = builder.build(inputStream);
				//根据sqlSessionFactory产生session
				session = factory.openSession();	
			}
			
			
		    @Test
		    public void testSelectUserById() throws Exception{
		    
		    	//根据session获取Mapper接口
		    	UserMapper mapper =session.getMapper(UserMapper.class);
		    	
		    	User user =mapper.selectUserById(1);
		   
		        System.out.println(user);
		        session.close();
		    }
}

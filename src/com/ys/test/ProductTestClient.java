package com.ys.test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ys.annocation.ProductMapper;
import com.ys.po.Product;
import com.ys.po.User;

public class ProductTestClient {
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
		
		
	    //@Test
	    public void testSelectProductById() throws Exception{
	    
	    	//根据session获取Mapper接口
	    	ProductMapper mapper =session.getMapper(ProductMapper.class);
	    	
	    	Product product =mapper.selectProductById(1);
	   
	        System.out.println(product);
	        session.close();
	    }
	    
	    @Test
	    public void testInsertProduct() throws Exception{
	    
	    	//根据session获取Mapper接口
	    	ProductMapper mapper =session.getMapper(ProductMapper.class);
	    	
	    	Product product = new Product();
	    	product.setName("成都鹭岛国际2");
	    	product.setDescription("成都玉林路2");
	    	product.setUnitPrice(new BigDecimal("123"));
	    	product.setIsNew(true);
	    	product.setImageUrl("image.jpg");
	    	mapper.insertProduct(product);
	    	
	    	session.commit();  //必须commit
	    	  System.out.println(product);
	    	session.close();
	      
	    }
		
		
}

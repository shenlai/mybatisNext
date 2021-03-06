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
import com.ys.po.User;
import com.ys.po.UserVo;

//使用mapper.userMapper.xml配置文件
public class TestClient {

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

	
	//查询所有user表所有数据
	//@Test
	public void testSelectAllUser() {
		String statement = "com.ys.po.userMapper.selectUserAll";
		List<User> listUser =session.selectList(statement);
		for(User user:listUser)
		{
			System.out.println(user);
		}
		session.close();	
	}
	
	 //根据id查询user表数据
    @Test
    public void testSelectUserById(){
        /*这个字符串由 userMapper.xml 文件中 两个部分构成
            <mapper namespace="com.ys.po.userMapper"> 的 namespace 的值
            <select id="selectUserById" > id 值*/
        String statement = "com.ys.po.userMapper.selectUserById";
        User user = session.selectOne(statement, 1);
        System.out.println(user);
        session.close();
    }
	
    
  //模糊查询：根据 user 表的username字段
   //@Test
    public void testSelectLikeUserName(){
        String statement = "com.ys.po.userMapper.selectLikeUserName";
        List<User> listUser = session.selectList(statement, "%测%");
        for(User user : listUser){
            System.out.println(user);
        }
        session.close();
         
    }
    
    
    //@Test
    public void testInsertUser() throws ParseException {
    	String statement = "com.ys.po.userMapper.insertUser";
    	User user = new User();
    	user.setUsername("普吉人");
    	user.setSex("男");
    	user.setAddress("上海市普陀区曹杨路2号");
    	  DateFormat df6 = new SimpleDateFormat("yyyy-MM-dd");
    	user.setBirthday(df6.parse("1993-11-30"));
    	session.insert(statement, user);
    	session.commit();
    	System.out.println(user);
    	session.close();
    }
    
    
   // @Test
    public void testUpdateUsernameById() {
    	String statement = "com.ys.po.userMapper.updateUserById";
    	//如果设置的 id不存在，那么数据库没有数据更改
        User user = new User();
        user.setId(2);
        user.setUsername("修改name");
        session.update(statement, user);
        session.commit();
        session.close();
    	
	}
	
    
    //@Test
    public void testDeleteUserById() {
    	String statement = "com.ys.po.userMapper.deleteUserById";
        session.delete(statement, 2);
        session.commit();
        session.close();
	}
    
    //@Test
    public void selectUserByUsernameAndSex(){  
        String statement = "com.ys.po.userMapperSql.selectUserByUsernameAndSex";
        User user = new User();
        //user.setUsername("普吉人");
        user.setSex("女");
        List<User> listUser = session.selectList(statement, user);
        session.commit();
        //HashMap<String, Object> map = new HashMap<String, Object>();    
        //map.put("sex", "男");    
        //map.put("username", "普吉小哥");  
        //List<User> listUser = session.selectList(statement, map);
        for(User u:listUser)
        {
        	System.out.println(u);
        }
        
        session.close();
    }
    
    //@Test
    public void updateUserById(){  
        String statement = "com.ys.po.userMapperSql.updateUserById";
        User user = new User();
        //user.setUsername("");
        user.setSex("谁");
        user.setId(1);
        session.update(statement, user);
        session.commit();
        
        String statement2 = "com.ys.po.userMapper.selectUserById";
        User newuser = session.selectOne(statement2, 1);
        
        System.out.println(newuser);
        session.close();
    }
    
    //@Test
    public void selectUserByChoose(){  
        String statement = "com.ys.po.userMapperSql.selectUserByChoose";
        User user = new User();
        user.setUsername("");
        user.setSex("女");
        user.setId(1);
        List<User> listUser = session.selectList(statement, user);
        session.commit();
        //HashMap<String, Object> map = new HashMap<String, Object>();    
        //map.put("sex", "男");    
        //map.put("username", "普吉小哥");  
        //List<User> listUser = session.selectList(statement, map);
        for(User u:listUser)
        {
        	System.out.println(u);
        }
        
        session.close();
    }
    
     //sql 引用片段
    //@Test
    public void selectUserByParameters(){  
        String statement = "com.ys.po.userMapperSql.selectUserByParameters";
        User user = new User();
        //user.setUsername("普吉人");
        user.setSex("女");
        List<User> listUser = session.selectList(statement, user);
        session.commit();
        for(User u:listUser)
        {
        	System.out.println(u);
        }
        
        session.close();
    }
    
    @Test
    public void testSelectUserByListId(){
        String statement = "com.ys.po.userMapperSql.selectUserByListId2";
        UserVo uv = new UserVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        uv.setIds(ids);
        List<User> listUser = session.selectList(statement, uv);
        for(User u : listUser){
            System.out.println(u);
        }
        session.close();
    }
    
}

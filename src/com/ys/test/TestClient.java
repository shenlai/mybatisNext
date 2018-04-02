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

//ʹ��mapper.userMapper.xml�����ļ�
public class TestClient {

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

	
	//��ѯ����user����������
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
	
	 //����id��ѯuser������
    @Test
    public void testSelectUserById(){
        /*����ַ����� userMapper.xml �ļ��� �������ֹ���
            <mapper namespace="com.ys.po.userMapper"> �� namespace ��ֵ
            <select id="selectUserById" > id ֵ*/
        String statement = "com.ys.po.userMapper.selectUserById";
        User user = session.selectOne(statement, 1);
        System.out.println(user);
        session.close();
    }
	
    
  //ģ����ѯ������ user ���username�ֶ�
   //@Test
    public void testSelectLikeUserName(){
        String statement = "com.ys.po.userMapper.selectLikeUserName";
        List<User> listUser = session.selectList(statement, "%��%");
        for(User user : listUser){
            System.out.println(user);
        }
        session.close();
         
    }
    
    
    //@Test
    public void testInsertUser() throws ParseException {
    	String statement = "com.ys.po.userMapper.insertUser";
    	User user = new User();
    	user.setUsername("�ռ���");
    	user.setSex("��");
    	user.setAddress("�Ϻ�������������·2��");
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
    	//������õ� id�����ڣ���ô���ݿ�û�����ݸ���
        User user = new User();
        user.setId(2);
        user.setUsername("�޸�name");
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
        //user.setUsername("�ռ���");
        user.setSex("Ů");
        List<User> listUser = session.selectList(statement, user);
        session.commit();
        //HashMap<String, Object> map = new HashMap<String, Object>();    
        //map.put("sex", "��");    
        //map.put("username", "�ռ�С��");  
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
        user.setSex("˭");
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
        user.setSex("Ů");
        user.setId(1);
        List<User> listUser = session.selectList(statement, user);
        session.commit();
        //HashMap<String, Object> map = new HashMap<String, Object>();    
        //map.put("sex", "��");    
        //map.put("username", "�ռ�С��");  
        //List<User> listUser = session.selectList(statement, map);
        for(User u:listUser)
        {
        	System.out.println(u);
        }
        
        session.close();
    }
    
     //sql ����Ƭ��
    //@Test
    public void selectUserByParameters(){  
        String statement = "com.ys.po.userMapperSql.selectUserByParameters";
        User user = new User();
        //user.setUsername("�ռ���");
        user.setSex("Ů");
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

package com.ys.annocation;
 
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
 
import com.ys.po.User;

public interface UserMapper {
	
	//���� id ��ѯ user ������
    @Select("select * from user where id = #{id}")
    public User selectUserById(int id) throws Exception;
 
    //�� user �����һ������
    @Insert("insert into user(username,sex,birthday,address) value(#{username},#{sex},#{birthday},#{address})")
    public void insertUser(User user) throws Exception;
     
    //���� id �޸� user ������
    @Update("update user set username=#{username},sex=#{sex} where id=#{id}")
    public void updateUserById(User user) throws Exception;
     
    //���� id ɾ�� user ������
    @Delete("delete from user where id=#{id}")
    public void deleteUserById(int id) throws Exception;
}

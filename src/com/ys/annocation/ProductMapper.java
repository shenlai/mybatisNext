package com.ys.annocation;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ys.po.Product;
import com.ys.po.User;

public interface ProductMapper {

	@Select("select * from products where Id = #{Id}")
	public Product selectProductById(int Id) throws Exception;

	@Insert("insert into products(`Name`,Description,UnitPrice,ImageUrl,IsNew) value(#{Name},#{Description},#{UnitPrice},#{ImageUrl},#{IsNew})")
	public void insertProduct(Product product) throws Exception;
	
	@Update("update products set description=#{Description},unitprice=#{UnitPrice} where id =#{id}")
	public void updateProductById(Product product) throws Exception;
	
    @Delete("delete from products where id=#{id}")
    public void deleteUserById(int id) throws Exception;
	
}

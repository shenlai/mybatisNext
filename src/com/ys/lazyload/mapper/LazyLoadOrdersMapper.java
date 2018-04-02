package com.ys.lazyload.mapper;

import java.util.List;

import com.ys.po.Orders;
import com.ys.po.User;

public interface LazyLoadOrdersMapper {
	
	public  List<Orders> getOrderByOrderId();
	
	public User getUserByUserId(int userID);
}

package com.ys.one2one.mapper;
import com.ys.po.Orders;
import com.ys.po.User;

public interface  OrdersMapper {

	/**
     * 方式一：嵌套结果
     * select * from orders o,user u where o.user_id=u.id and o.id=#{id}
     * @param orderId
     * @return
     */
	public Orders selectOrderAndUserByOrderID(int orderId);
}

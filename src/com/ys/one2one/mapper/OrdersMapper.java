package com.ys.one2one.mapper;
import com.ys.po.Orders;
import com.ys.po.User;

public interface  OrdersMapper {

	/**
     * ��ʽһ��Ƕ�׽��
     * select * from orders o,user u where o.user_id=u.id and o.id=#{id}
     * @param orderId
     * @return
     */
	public Orders selectOrderAndUserByOrderID(int orderId);
	
	/**
     * ��ʽ����Ƕ�ײ�ѯ
     * select * from order WHERE id=1;//�õ�user_id
     * select * from user WHERE id=1   //1 ����һ����ѯ�õ���user_id��ֵ
     * @param userID
     * @return
     */
	public Orders getOrderByOrderId(int orderId);
}

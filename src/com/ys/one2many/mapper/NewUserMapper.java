package com.ys.one2many.mapper;

import com.ys.po.User;

public interface NewUserMapper {

	//根据用户id查询用户信息，以及用户下面的所有订单信息
    public User selectUserAndOrdersByUserId(int UserId);
}

package com.ys.one2many.mapper;

import com.ys.po.User;

public interface NewUserMapper {

	//�����û�id��ѯ�û���Ϣ���Լ��û���������ж�����Ϣ
    public User selectUserAndOrdersByUserId(int UserId);
}

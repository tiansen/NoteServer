package com.ferraborghini.dao;

import com.ferraborghini.bean.User;

public interface IUserDao extends BaseDao<User>{
	/**
	 * �����û�������������û�
	 * @param username ��ѯ������û���
	 * @param pass ��ѯ���������
	 * @return ָ���û����������Ӧ���û�
	 */
	User findUserByNameAndPass(String name, String pwd);
}

package com.ferraborghini.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ferraborghini.bean.User;
import com.ferraborghini.dao.IUserDao;

public class UserDao  extends BaseDaoHibernate4<User> implements IUserDao{

	@Override
	/**
	 * �����û�������������û�
	 * @param username ��ѯ������û���
	 * @param pass ��ѯ���������
	 * @return ָ���û����������Ӧ���û�
	 */
	public User findUserByNameAndPass(String name, String pwd) {
		System.out.println("____"+name+"_________");
		//������滹����д��0,1
		List<User> ul = (List<User>)find(
				"from User as u where u.name=?0 and u.pwd=?1" ,
				name , pwd);
			// ���ز�ѯ�õ��ĵ�һ��User����
			if (ul.size() == 1)
			{
				return (User)ul.get(0);
			}
			return null;
	}

}

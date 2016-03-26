package com.ferraborghini.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ferraborghini.bean.User;
import com.ferraborghini.dao.IUserDao;

public class UserDao  extends BaseDaoHibernate4<User> implements IUserDao{

	@Override
	/**
	 * 根据用户名，密码查找用户
	 * @param username 查询所需的用户名
	 * @param pass 查询所需的密码
	 * @return 指定用户名、密码对应的用户
	 */
	public User findUserByNameAndPass(String name, String pwd) {
		System.out.println("_________"+name+"_________");
		//这个后面还必须写上0,1
		List<User> ul = (List<User>)find(
				"from User as u where u.name=?0 and u.pwd=?1" ,
				name , pwd);
			// 返回查询得到的第一个User对象
			if (ul.size() == 1)
			{
				return (User)ul.get(0);
			}
			return null;
	}

	@Override
	public boolean getName(String name) {
		List<User> ul = (List<User>)find(
				"from User as u where u.name=?0" ,
				name);
			// 返回查询得到的第一个User对象
			if (ul.size() == 1)
			{
				return true;
			}
			return false;
	}

	@Override
	public boolean addUser(User user) {
		if (save(user)!=null) {
			return true;
		}
		return false;
	}

}

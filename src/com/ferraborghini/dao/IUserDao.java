package com.ferraborghini.dao;

import com.ferraborghini.bean.User;

public interface IUserDao extends BaseDao<User>{
	/**
	 * 根据用户名，密码查找用户
	 * @param username 查询所需的用户名
	 * @param pass 查询所需的密码
	 * @return 指定用户名、密码对应的用户
	 */
	User findUserByNameAndPass(String name, String pwd);
}

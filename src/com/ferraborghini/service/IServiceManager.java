package com.ferraborghini.service;

import com.ferraborghini.bean.User;


public interface IServiceManager {
	/**
	 * 根据用户名，密码验证登录是否成功
	 * @param username 登录的用户名
 	 * @param pass 登录的密码
	 * @return 登录成功返回用户ID，否则返回-1
	 */
	User validLogin(String username , String pass);
}

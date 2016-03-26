package com.ferraborghini.service.impl;


import java.util.jar.Attributes.Name;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ferraborghini.bean.User;
import com.ferraborghini.dao.impl.UserDao;
import com.ferraborghini.service.IServiceManager;

@Transactional//事务管理
@Service
public class ServiceManager implements IServiceManager {
	@Setter @Getter
	UserDao userDao;

	/**
	 * 根据用户名，密码验证登录是否成功
	 * 
	 * @param username
	 *            登录的用户名
	 * @param pass
	 *            登录的密码
	 * @return 登录成功返回用户信息
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly = true)
	public User validLogin(String username, String pass) {

		User u = userDao.findUserByNameAndPass(username, pass);
		if (u != null) {
			return u;
		}
		return null;
	}
	
	/**
	 * 检测用户名是否已经被注册
	 * @param name
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly = true)
	public boolean getName(String name) {
		return userDao.getName(name);
	}

	/**
	 * 添加用户
	 */
	@Override
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

}

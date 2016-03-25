package com.ferraborghini.service.impl;


import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ferraborghini.bean.User;
import com.ferraborghini.dao.impl.UserDao;
import com.ferraborghini.service.IServiceManager;

@Transactional//�������
public class ServiceManager implements IServiceManager {
	@Setter @Getter
	UserDao userDao;

	/**
	 * �����û�����������֤��¼�Ƿ�ɹ�
	 * 
	 * @param username
	 *            ��¼���û���
	 * @param pass
	 *            ��¼������
	 * @return ��¼�ɹ������û���Ϣ
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly = true)
	public User validLogin(String username, String pass) {

		User u = userDao.findUserByNameAndPass(username, pass);
		if (u != null) {
			return u;
		}
		return null;
	}

}

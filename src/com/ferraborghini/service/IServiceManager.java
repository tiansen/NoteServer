package com.ferraborghini.service;

import com.ferraborghini.bean.User;


public interface IServiceManager {
	/**
	 * �����û�����������֤��¼�Ƿ�ɹ�
	 * @param username ��¼���û���
 	 * @param pass ��¼������
	 * @return ��¼�ɹ������û�ID�����򷵻�-1
	 */
	User validLogin(String name , String pwd);
	
	/**
	 * ����û����Ƿ��Ѿ���ע��
	 * @param name
	 * @return
	 */
	boolean getName(String name);
	/**
	 * ����û�
	 * @return
	 */
	boolean addUser(User user);
}
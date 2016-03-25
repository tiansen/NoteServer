package com.ferraborghini.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;

import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.ferraborghini.bean.User;
import com.ferraborghini.service.IServiceManager;
import com.ferraborghini.service.impl.ServiceManager;
import com.ferraborghini.servlet.base.BaseServlet;

@WebServlet(urlPatterns="/note/login.jsp")
public class LoginServlet extends BaseServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String name = "admin";//request.getParameter("name");
		String pwd = "admin";//request.getParameter("pwd");
		// ��ȡϵͳ��ҵ���߼����
		
		// ��֤�û���¼
		System.out.println("��ʼ��֤");
		//�˴�ֻ���ýӿ�
		IServiceManager serviceManager = (IServiceManager)getCtx().getBean("mgr");
		User u = serviceManager.validLogin(name , pwd);
		System.out.println("��֤����");
		response.setContentType("text/html; charset=utf-8");
		// ��¼�ɹ�
		if (u!=null)
		{
			request.getSession(true).setAttribute("name" , name);
		}
		try
		{
			// ����֤��userId��װ��JSONObject
			JSONObject jsonObj = new JSONObject()
				.fromObject(u);
			// �����Ӧ
			response.getWriter().println(jsonObj.toString());
		}
		catch (JSONException ex)
		{
			ex.printStackTrace();
		}
	}
}

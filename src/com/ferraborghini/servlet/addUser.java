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

@WebServlet(urlPatterns="/note/addUser.jsp")
public class addUser extends BaseServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String label = request.getParameter("label");
		// ��ȡϵͳ��ҵ���߼����
		User user = new User(name, pwd, sex, label);
		// ��֤�û���¼
		//�˴�ֻ���ýӿ�
		IServiceManager serviceManager = (IServiceManager)getCtx().getBean("mgr");
		Boolean flag = serviceManager.addUser(user);
		response.setContentType("text/html; charset=utf-8");
		// ��¼�ɹ�
		System.out.println(flag);
		if (flag) {
			response.getWriter().println("OK");
		}else{
			response.getWriter().println("FALSE");
		}
			
		
	}
}

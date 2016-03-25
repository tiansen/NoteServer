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
		// 获取系统的业务逻辑组件
		
		// 验证用户登录
		System.out.println("开始验证");
		//此处只能用接口
		IServiceManager serviceManager = (IServiceManager)getCtx().getBean("mgr");
		User u = serviceManager.validLogin(name , pwd);
		System.out.println("验证结束");
		response.setContentType("text/html; charset=utf-8");
		// 登录成功
		if (u!=null)
		{
			request.getSession(true).setAttribute("name" , name);
		}
		try
		{
			// 把验证的userId封装成JSONObject
			JSONObject jsonObj = new JSONObject()
				.fromObject(u);
			// 输出响应
			response.getWriter().println(jsonObj.toString());
		}
		catch (JSONException ex)
		{
			ex.printStackTrace();
		}
	}
}

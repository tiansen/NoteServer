package com.ferraborghini.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.ast.Not;
import org.springframework.context.annotation.Scope;

import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.ferraborghini.bean.User;
import com.ferraborghini.service.IServiceManager;
import com.ferraborghini.service.impl.ServiceManager;
import com.ferraborghini.servlet.base.BaseServlet;

@WebServlet(urlPatterns="/note/getName.jsp")
public class GetNameServlet extends BaseServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String name = request.getParameter("name");
		// 获取系统的业务逻辑组件
		
		// 验证用户登录
		//此处只能用接口
		IServiceManager serviceManager = (IServiceManager)getCtx().getBean("mgr");
		Boolean flag = serviceManager.getName(name);
		response.setContentType("text/html; charset=utf-8");
		// 登录成功
		System.out.println(flag);
		if (flag) {
			response.getWriter().print("exists");
		}else {
			response.getWriter().println("not exists");
		}
	}
}

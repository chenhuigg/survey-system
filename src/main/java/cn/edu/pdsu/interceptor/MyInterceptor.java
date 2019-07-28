package cn.edu.pdsu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.pdsu.pojo.Admin;
import cn.edu.pdsu.pojo.Student;

public class MyInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//ªÒ»°¡¥Ω”
		String pathInfo = request.getPathInfo();
		if(pathInfo.contains("/user/")) {
			Student student=(Student) request.getSession().getAttribute("student");
			if(student==null) {
				return false;
			}
		}
		
		if(pathInfo.contains("/admin/")) {
			Admin admin = (Admin) request.getSession().getAttribute("admin");
			if(admin==null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}

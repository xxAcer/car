package cn.prince.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.prince.pojo.Customers;
import cn.prince.pojo.User;

public class My implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		System.out.println("uri========================="+uri);
		/*if(uri.endsWith("index")) {
			return true;
		}else if(uri.endsWith("code")){
			
			return true;
		}else {
			return false;
		}*/
		User name = (User) request.getSession().getAttribute("user");
		Customers c = (Customers) request.getSession().getAttribute("customers");
		System.out.println("kehu+++++++++++++++"+c);
		System.out.println(c!=null);
		if (uri.endsWith("code")) {
			return true;
		}else if(uri.endsWith("css")) {
			return true;
		}else if(uri.endsWith("js")) {
			return true;
		}else if(uri.endsWith("png")) {
			return true;
		}else if(uri.endsWith("ttf")) {
			return true;
		}else if(uri.endsWith("jpg")) {
			return true;
		}
		/*else if(name == null){
			return false;
		}else {
			request.getRequestDispatcher("login").forward(request, response);
			return true;
		}
		*/
//		return true;
		return true;
	}

}

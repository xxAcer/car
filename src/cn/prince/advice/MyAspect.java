package cn.prince.advice;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.aop.AfterReturningAdvice;

import cn.prince.mapper.LoginlogMapper;
import cn.prince.pojo.Logs;
import cn.prince.pojo.User;

public class MyAspect implements AfterReturningAdvice {
	@Resource
	HttpServletRequest request;
	@Resource
	LoginlogMapper loginMapper;

	@Override
	public void afterReturning(Object value, Method method, Object[] args, Object tarject) throws Throwable {
		Date d = new Date();
		System.out.println("后置通知--------" + method.getName());
		if ("add".equals(method.getName())) {
			String username = (String) request.getSession().getAttribute("loginName");
			String action = "添加用户";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateNowStr = sdf.format(d);

			loginMapper.addLog(username, action, dateNowStr);
		}
		if ("addCar".equals(method.getName())) {
			String username = (String) request.getSession().getAttribute("loginName");
			String action = "添加汽车";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateNowStr = sdf.format(d);

			loginMapper.addLog(username, action, dateNowStr);
		}
		if ("check".equals(method.getName())) {
			String username = (String) request.getSession().getAttribute("loginName");
			String action = "检查汽车";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateNowStr = sdf.format(d);
			loginMapper.addLog(username, action, dateNowStr);
		}
	}

}

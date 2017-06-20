package cn.prince.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.prince.pojo.Customers;
import cn.prince.pojo.Menu;
import cn.prince.pojo.User;
import cn.prince.service.MenuService;

@Controller
public class MenuController {
	
	@Resource
	MenuService menuService;
	
	@RequestMapping("index")
	public String index(User user, HttpServletRequest request) {
		User u = (User) request.getSession().getAttribute("user");
		Customers c = (Customers) request.getSession().getAttribute("customers");
		if(u != null) {
			int id = u.getUserid();
			List<Menu> menus = menuService.findMenuById(id);
			request.setAttribute("menus", menus);
		}else {
			int id1 = c.getId();
			List<Menu> menus = menuService.findMenuById1(id1);
			request.setAttribute("menus", menus);
		}
		
		return "index";
		
	}
	
}

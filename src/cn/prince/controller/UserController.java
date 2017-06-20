package cn.prince.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.prince.pojo.Car;
import cn.prince.pojo.Customers;
import cn.prince.pojo.User;
import cn.prince.service.CustomersService;
import cn.prince.service.LoginlogService;
import cn.prince.service.UserService;
import cn.prince.utils.Ip;

@Controller
public class UserController {

	@Resource
	UserService userService;
	@Resource
	CustomersService customersService;
	@Resource
	LoginlogService loginlogService;

	@RequestMapping("login")
	@ResponseBody
	public String login(User user, HttpServletRequest request) {
		Map map = new HashMap<>();
		Ip ip = null;
		Date d = new Date();

		String code = request.getParameter("code");
		String sessionCode = (String) request.getSession().getAttribute("code");
		System.out.println(user.getUsername() + "--_______" + user.getPassword());
		String name = user.getUsername();
		request.getSession().setAttribute("loginName", name);
		String pwd = user.getPassword();
		String role = request.getParameter("role");
		System.out.println("权限+++++++++++++++++" + role);
		if (code.equalsIgnoreCase(sessionCode)) {

			if ("user".equals(role)) {
				Customers c = customersService.login(name, pwd);
				if (c != null) {
					request.getSession().setAttribute("customers", c);
					map.put("flg", "ok");
				} else {
					map.put("flg", "ng");
				}
			} else {
				User u = userService.login(user.getUsername(), user.getPassword());
				if (u != null) {
					request.getSession().setAttribute("user", u);
					map.put("flg", "ok");
				} else {
					map.put("flg", "ng");
				}
			}
		} else {
			map.put("flg", "ng");
		}

		String ipAddr = ip.getIpAddr(request);
		String username = user.getUsername();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr = sdf.format(d);
		System.out.println("ip ++++++++++++" + ipAddr + username + dateNowStr);

		loginlogService.loginlogAdd(username, ipAddr, dateNowStr);

		Gson gson = new Gson();
		String str = gson.toJson(map);
		System.out.println(str);
		return str;
	}

	@RequestMapping("find")
	@ResponseBody
	public String find(HttpServletRequest request) {
		Map map = new HashMap<>();
		List<Customers> list1 = new ArrayList<>();

		List<User> list = userService.findAll();
		list1 = customersService.findAll();
		System.out.println("客户的信息+++++++++++++++++" + list1.size());
		if (list.size() > 0 || list1.size() > 0) {
			request.getSession().setAttribute("list", list);
			request.getSession().setAttribute("list1", list1);
			map.put("flg", "ok");
		} else {
			map.put("flg", "ng");
		}
		return "find-form";
	}

	@RequestMapping("add")
	@ResponseBody
	public String add(User user, HttpServletRequest request) {
		Map map = new HashMap<>();
		Integer id = 0;
		int i = 0;

		String username = request.getParameter("username");
		String identity = request.getParameter("identity");
		String fullname = request.getParameter("fullname");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String roleid = request.getParameter("roleid");
		String position = request.getParameter("postition");

		System.out.println("code-----------" + roleid);
		System.out.println("position-----------" + position);

		if (roleid != null) {
			id = Integer.parseInt(roleid);
		}

		User u = new User(0, username, identity, fullname, sex, address, phone, password, id, position);
		Customers cu = new Customers(0, username, password, fullname, sex, address, phone, position, id);

		if (roleid.equals("3")) {
			i = customersService.add(cu);
		} else {
			i = userService.add(u);

		}

		if (i > 0) {
			map.put("flg", "ok");
		} else {
			map.put("flg", "ng");
		}
		Gson gson = new Gson();
		String str = gson.toJson(map);
		System.out.println(str);
		return str;
	}

	@RequestMapping("removeUser")
	public String removeUser(HttpServletRequest request, HttpServletResponse response) {
		Map map = new HashMap<>();
		String username = request.getParameter("username");

		int i = userService.removeUser(username);

		if (i > 0) {
			map.put("flg", "ok");
		} else {
			map.put("flg", "ng");
		}
		return "find-from";
	}

	@RequestMapping("removeCu")
	public String removeCu(HttpServletRequest request, HttpServletResponse response) {
		Map map = new HashMap<>();
		String cname = request.getParameter("cname");

		int i = customersService.removeCu(cname);

		if (i > 0) {
			map.put("flg", "ok");
		} else {
			map.put("flg", "ng");
		}
		return "find-from";
	}

	// 根据 nam 查出来 那条信息

	@RequestMapping("findUserByName")
	public String findUserByName(HttpServletRequest request) {
		Map map = new HashMap<>();
		Integer id = 0;
		String username = request.getParameter("username");
		User user = userService.findUserByName(username);
		request.getSession().setAttribute("userByNmae", user);

		return "updateUser";
	}

	@RequestMapping("findCuByName")
	public String findCuByName(HttpServletRequest request) {
		Map map = new HashMap<>();
		String cname = request.getParameter("cname");
		Customers customers = customersService.findCuByName(cname);
		request.getSession().setAttribute("customerByName", customers);

		return "updatefrom";
	}

	@RequestMapping("updateUser")
	@ResponseBody
	public String updateUser(User user, HttpServletRequest request) {
		Map map = new HashMap<>();
		Integer id = 0;
		int i = 0;

		String username = request.getParameter("username");
		String identity = request.getParameter("identity");
		String fullname = request.getParameter("fullname");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String roleid = request.getParameter("roleid");
		String position = request.getParameter("postition");

		if (roleid != null) {
			id = Integer.parseInt(roleid);
		}

		User u = new User(0, username, identity, fullname, sex, address, phone, password, id, position);

		i = userService.updateUser(u);

		if (i > 0) {
			map.put("flg", "ok");
		} else {
			map.put("flg", "ng");
		}
		Gson gson = new Gson();
		String str = gson.toJson(map);
		System.out.println(str);
		return str;
	}

	@RequestMapping("updateCu")
	@ResponseBody
	public String updateCu(User user, HttpServletRequest request) {
		Map map = new HashMap<>();
		Integer id = 0;
		int i = 0;

		String username = request.getParameter("username");
		String identity = request.getParameter("identity");
		String fullname = request.getParameter("fullname");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String roleid = request.getParameter("roleid");
		String position = request.getParameter("postition");

		if (roleid != null) {
			id = Integer.parseInt(roleid);
		}

		Customers cu = new Customers(0, username, identity, fullname, sex, address, phone, password, id);

		i = customersService.updateCu(cu);

		if (i > 0) {
			map.put("flg", "ok");
		} else {
			map.put("flg", "ng");
		}
		Gson gson = new Gson();
		String str = gson.toJson(map);
		System.out.println(str);
		return str;
	}

}

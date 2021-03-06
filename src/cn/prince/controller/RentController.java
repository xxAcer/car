package cn.prince.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.prince.pojo.Car;
import cn.prince.pojo.Customers;
import cn.prince.pojo.Rent;
import cn.prince.service.CarService;
import cn.prince.service.RentService;

@Controller
public class RentController {

	@Resource
	RentService rentService;
	
	@Resource
	CarService carService;
	
	
	
	
	
	
	
	//还车功能 还车之后 要把出租单里面汽车状态改成 以还
	@RequestMapping("huanche")
	public String huanche(HttpServletRequest request) {
		
		String tableid = request.getParameter("tableid");
		System.out.println("出租单-----------------"+tableid);
		String carnumber = request.getParameter("carnumber");
		request.getSession().setAttribute("carnumber", carnumber);
		int id = 0;
		if(tableid != null) {
			id = Integer.parseInt(tableid);
		}
		int i = rentService.update(id);
		
		
		
		return null;
		
	}
	
	//查询全部的 出租单数据
	@RequestMapping("allrent")
	@ResponseBody
	public String allrent(HttpServletRequest request) {
		Map map = new HashMap<>();
		List<Rent> rent = rentService.allrent();
		request.getSession().setAttribute("rent", rent);
		System.out.println("++++++++++++"+rent.size());
		
		if(rent.size()>0) {
			map.put("flg", "ok");
		}else {
			map.put("flg", "ng");
		}
		
		Gson gson = new Gson();
		String str = gson.toJson(map);
		System.out.println(str);
		return str;
	}
	
	//查询全部的 临时租车表数据
	@RequestMapping("allrentorder")
	@ResponseBody
	public String allrentorder(HttpServletRequest request) {
		Map map = new HashMap<>();
		Customers c = (Customers) request.getSession().getAttribute("customers");
		System.out.println("客户名称+++++++++++");
		List<Rent> rentorder = rentService.allrentorder();
		request.getSession().setAttribute("rentorder", rentorder);
		
		if(rentorder.size()>0) {
			map.put("flg", "ok");
		}else {
			map.put("flg", "ng");
		}
		
		Gson gson = new Gson();
		String str = gson.toJson(map);
		System.out.println(str);
		return str;
	}
	
	//验车转发页面
	@RequestMapping("yan")
	public String yanche (HttpServletRequest request) {
		
		int tableid = Integer.parseInt(request.getParameter("tableid"));
		Rent rents = rentService.findById(tableid);
		request.getSession().setAttribute("rents", rents);
		
		System.out.println(rents);
		
		return "jianche";
		
	}
	
	//根据id 查询出申请单信息 然后在插入到出租单里面 确认租车
	@RequestMapping("confirm")
	public String confirm (HttpServletRequest request) {
		
		int tableid = Integer.parseInt(request.getParameter("tableid"));
		Rent rent = rentService.findByIdOrder(tableid);
		
//		request.getSession().setAttribute("rent", rent);
		
		
		int i = rentService.add(rent);
		rentService.updateByIdOrder(tableid);
		
		System.out.println(rent);
		
		return "yinghuanche";
		
	}
	
	//查询全部应还汽车的页面 查询 出租单信息
	@RequestMapping("yinghuan")
	public String yinghuanche(HttpServletRequest request) {
	Map map = new HashMap<>();
	int carflag = 0;
	List<Rent> c = rentService.yingHun(carflag);
	request.getSession().setAttribute("yinghuan", c);
	System.out.println("++++++++++++"+c.size());
	
	if(c.size()>0) {
		map.put("flg", "ok");
	}else {
		map.put("flg", "ng");
	}
	
	Gson gson = new Gson();
	String str = gson.toJson(map);
	System.out.println(str);
	return str;
	}
	
	//申请还车
	@RequestMapping("rentByC")
	@ResponseBody
	public String rentByC(HttpServletRequest request) {
		Map map = new HashMap<>();
		Customers cu = (Customers) request.getSession().getAttribute("customers");
		String name = cu.getCname();
		List<Rent> shenqinghuanche = rentService.rentByC(name);
		request.getSession().setAttribute("shenqinghuanche", shenqinghuanche);
		
		if(shenqinghuanche.size()>0) {
			map.put("flg", "ok");
		}else {
			map.put("flg", "ng");
		}
		
		Gson gson = new Gson();
		String str = gson.toJson(map);
		System.out.println(str);
		return str;
	}
	
	//查询临时出租单信息 条件是用户的名字
	@RequestMapping("rentorderByC")
	@ResponseBody
	public String rentorderByC(HttpServletRequest request) {
		Map map = new HashMap<>();
		Customers cu = (Customers) request.getSession().getAttribute("customers");
		String name  = cu.getCname();
		List<Rent> shenqingzuche = rentService.rentorderByC(name);
		request.getSession().setAttribute("shenqingzuche", shenqingzuche);
		
		if(shenqingzuche.size()>0) {
			map.put("flg", "ok");
		}else {
			map.put("flg", "ng");
		}
		
		Gson gson = new Gson();
		String str = gson.toJson(map);
		System.out.println(str);
		return str;
	}
	
	//查询临时出租单信息 条件是用户的名字
		@RequestMapping("rentorderAndcheck")
		@ResponseBody
		public String rentorderAndcheck(HttpServletRequest request) {
			Map map = new HashMap<>();
			Customers cu = (Customers) request.getSession().getAttribute("customers");
			String name  = cu.getCname();
			List<Rent> shenqingzuche = rentService.rentorderByC(name);
			request.getSession().setAttribute("shenqingzuche", shenqingzuche);
			
			if(shenqingzuche.size()>0) {
				map.put("flg", "ok");
			}else {
				map.put("flg", "ng");
			}
			
			Gson gson = new Gson();
			String str = gson.toJson(map);
			System.out.println(str);
			return str;
		}
}

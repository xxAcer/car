package cn.prince.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.prince.pojo.Roles;
import cn.prince.service.RolesService;

@Controller
public class RolesController {
	@Resource
	RolesService rolesService;
	
	@RequestMapping(value = "role",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String role(Roles roles, HttpServletResponse response) {
		List<Map> list1 = new ArrayList<Map>();
		List<Roles> list = rolesService.find();
		String name = "";
		Integer id = 0;
		for(int i=0; i<list.size(); i++) {
			Map rMap = new HashMap();
			 name = list.get(i).getRolename();
			 id = list.get(i).getRoleid();
			 System.out.println("id" + id);
			 System.out.println("name" +name);
			 rMap.put("code", id);
			 rMap.put("name",name);
			 list1.add(rMap);
		}
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		Gson json = new Gson();
		String jsonStr = json.toJson(list1);
		System.out.println(jsonStr);
		return jsonStr;
		
	}
	
}

package cn.prince.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	@RequestMapping("/{path}")
	public String path(@PathVariable(value="path") String path) {
		System.out.println("————————————————走了这里");
		return path;
	}
}

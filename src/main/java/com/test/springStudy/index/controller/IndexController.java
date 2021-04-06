package com.test.springStudy.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//url-mapping
@Controller
public class IndexController{
	public IndexController() {
		
	}
	
	@RequestMapping("/")
	public String index() {
		return "main/main";
	}
}
package com.shop2.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.shop2.myapp.dto.UserDTO;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String Index(@SessionAttribute( name="logUsr", required=false ) UserDTO logUsr, Model model ) {
		String id = "";
		if(logUsr != null) {
			id = logUsr.getId();
		}
		model.addAttribute("sid", id);
		model.addAttribute("logUsr", logUsr);
		return "/index";
	}
}

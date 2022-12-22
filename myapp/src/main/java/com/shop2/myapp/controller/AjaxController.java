package com.shop2.myapp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop2.myapp.dto.UserDTO;
import com.shop2.myapp.service.AjaxService;

@Controller
@RequestMapping("/ajax/")
public class AjaxController {
	
	@Resource
	private AjaxService ajaxService;
	
	@Autowired
	HttpSession session;
	
	//test1 로딩
	@GetMapping("test1")
	public String testLoad() throws Exception {
		return "ajax/test1";
	}
	//아이디 중복체크
	@GetMapping("idCheck.do")
	@ResponseBody
	public boolean idCheck(@RequestParam("id") String id) throws Exception {
		UserDTO user = ajaxService.getUser(id);
		if(user==null) {
			return true;
		} else {
			return false;
		}
	}
	
	//test2 로딩
	@GetMapping("test2")
	public String testLoad2() throws Exception {
		return "ajax/test2";
	}
	//회원목록
	@GetMapping("userList.do")
	@ResponseBody
	public List<UserDTO> userList() throws Exception {
		List<UserDTO> userList = ajaxService.userList();
		return userList;
	}
	
	//test3 로딩
	@GetMapping("test3")
	public String testLoad3() throws Exception {
		return "ajax/test3";
	}
	//회원정보
	@GetMapping("getUser.do")
	@ResponseBody
	public UserDTO getUser(@RequestParam("id") String id) throws Exception {
		UserDTO user = ajaxService.getUser(id);
		return user;
	}
	
	//test3 로딩
	@GetMapping("test4")
	public String testLoad4() throws Exception {
		return "ajax/test4";
	}
	//회원정보
	/*@PostMapping("getLogin.do")
	@ResponseBody
	public HttpSession login(@ModelAttribute("user") UserDTO user) throws Exception {
		UserDTO usr = ajaxService.getLogin(user.getId(), user.getPw());
	}*/
	@GetMapping("getLogin.do")
	@ResponseBody
	public UserDTO getLogin(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) throws Exception {
		UserDTO usr = ajaxService.getLogin(id, pw);
		if(usr==null) {
			session.invalidate();
		} else {
			session.setAttribute("sid", usr.getId());
			session.setAttribute("sname", usr.getName());
		}
		return usr;
	}	
}

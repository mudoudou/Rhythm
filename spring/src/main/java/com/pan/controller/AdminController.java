package com.pan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pan.po.Admin;
import com.pan.po.MD5Util;
import com.pan.po.Student;
import com.pan.service.AdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="login")
	public String login(Model model,HttpServletRequest request,String username,String password) throws Exception{
		System.out.println("admin-----------login");
		if(password.equals(adminService.login(username))){
			request.getSession().setAttribute("admin", username);
			model.addAttribute("login_result", "登入成功了！");
			return "result";
		}
		return "login";
	}
	
	@RequestMapping(value="/tologin")
	public String toLgoin(){
		System.out.println("------toLgoin--------====");
		return "regist";
	}
	

	@RequestMapping(value="/addadmin")
	public String addadmin(HttpServletRequest request,Student student) throws Exception{
		System.out.println("------addadmin--------====");
		MD5Util md5 = new MD5Util();
		student.setName(md5.makeVertify(student.getName()));
		adminService.addstu(student);
		return "redirect:stulist.action";
	}
	@RequestMapping(value="/regist")
	public String addadmin(Admin admin){
		System.out.println("------regist--------====");
		System.out.println(admin.getUsername()+"--======"+admin.getPassword());
		MD5Util md5 = new MD5Util();
		String pwd = md5.makeVertify(admin.getPassword());
		
		return "regist";
	}
	
	@RequestMapping(value="stulist")
	public String stulist(Model model) throws Exception{
		System.out.println("stulist");
		List<Student> itemsList = adminService.liStudents();
		model.addAttribute("itemsList", itemsList);
		
		return "itemsList";
		}
}

package com.pan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/user")
public class UserinfoController {
    
	
	
	
	
	@RequestMapping(value="/tologin")
	public String toLgoin(){
		return "login";
	}
    @RequestMapping(value = "/login")
    public String userLogin(HttpServletRequest request,Model model,String username,String password){
      
        System.out.println("开始执行登录操作," + "用户名：" + username + ",密码：" + password);
        String login_result = "";
        if("panfei".equals(username) && "123456".equals(password)){
            login_result = "登录成功";
            HttpSession session = request.getSession();
    	    session.setAttribute("username", username);
        }else{
            login_result = "登录失败";
            return "login";
        }
        model.addAttribute("login_result",login_result);
        return "index";
    }
    @RequestMapping(value="/toindex")
	public String toIndex(HttpServletRequest request){
    	
		return "index";
	}
    @RequestMapping(value="/loginout")
   	public String loginout(HttpServletRequest request){
       	if(request.getSession().getAttribute("username") != null)
       		request.getSession().removeAttribute("username");
   		return "login";
   	}
}
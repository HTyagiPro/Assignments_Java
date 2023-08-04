package com.har.spMVC.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.har.spMVC.beans.User;
import com.har.spMVC.dao.UserDAO;

@Controller
public class LogInController {
	@Autowired
	UserDAO udao;
	
	@GetMapping("/loginPage")
	public String getLoginPage() {
		return "Login";
	}
	
	@PostMapping("/validateUser")
	public String validateuser(@RequestParam("uname")String username,@RequestParam("pass")String password, Model model, HttpServletResponse response  ) {
		String message = "Invalid Username/Password... ";
		User user = new User(username, password);
		 
		try {
		if (udao.searchUSer(user)) {
			response.addCookie(new Cookie("username", username));
			return "Services";
			
		}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		model.addAttribute("Usermessage",message);
		
		return "Display";
	}
	
	/*
	 
	@PostMapping("/validateUser")
	public String validateuser(@RequestParam("uname")String username,@RequestParam("pass")String password, Model model  ) {
		String message = "Invalid Username/Password... ";
		User user = new User(username, password);
		 
		try {
		if (udao.searchUSer(user))
			message = "Hello " + username + ", Welcome to MVC World";
		}catch (Exception e) {
			System.out.println(e);
		}
		model.addAttribute("Usermessage",message);
		
		return "Display";
	} 
	 * */
	
	
	
	/*
	@GetMapping("/validateUser")
	public String validateuser(@RequestParam("uname")String username,@RequestParam("pass")String password, Model model  ) {
		String message = "Invalid Username/Password... ";
		if (username.equals("Ajay") && password.equals("Password"))
			message = "Hello " + username + ", Welcome to MVC World";
		model.addAttribute("Usermessage",message);
		return "Display";
	}
	*/
	
	/*
	@GetMapping("/validateUser")
	public ModelAndView validateuser(@RequestParam("uname")String username,@RequestParam("pass")String password  ) {
		String message = "Invalid Username/Password... ";
		if (username.equals("Ajay") && password.equals("Password"))
			message = "Hello " + username + ", Welcome to MVC World";
		//model.addAttribute("Usermessage",message);
		return new ModelAndView("Display","Usermessage",message );
	}
	*/
	
}

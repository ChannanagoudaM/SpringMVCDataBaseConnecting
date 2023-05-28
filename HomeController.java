package com.hlo;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/login")
	public ModelAndView check(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("password");
		Service s=new Service();
		if(s.check(uname, pass))
		{
			mv.setViewName("welcome.jsp");	
		}
		else
		{
			mv.setViewName("index.jsp");

		}
		return mv;
	}
}

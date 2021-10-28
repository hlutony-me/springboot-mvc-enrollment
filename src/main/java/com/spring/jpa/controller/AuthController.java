package com.spring.jpa.controller;

import com.spring.jpa.model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.spring.jpa.model.User;
import com.spring.jpa.repository.ProgramRepo;
import com.spring.jpa.repository.UserRepo;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"user"})
public class AuthController {
	
	@Autowired
	private UserRepo userRepo;
	
    @Autowired
    private ProgramRepo programRepo;
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView modelAndView = new ModelAndView();
		 modelAndView.addObject("message","");
	     modelAndView.setViewName("index");
	     return modelAndView;
	}
	
	@PostMapping("/login")
    public @ResponseBody ModelAndView login(@RequestParam("userName") String userName,
            @RequestParam("password") String password,ModelMap modelMap )
    {
		User user = userRepo.findByUserName(userName);
		ModelAndView modelAndView = new ModelAndView();
		if(user==null) {
			
	        modelAndView.addObject("message","Invalid Credentials");
	        modelAndView.setViewName("index");
	        return modelAndView;
		}
		if(!user.getPassword().equals(password)) {
			modelAndView.addObject("message","Invalid Credentials");
	        modelAndView.setViewName("index");
	        return modelAndView;
		}
        modelAndView.addObject("programs",programRepo.findAll());
        modelAndView.addObject("userName",userName);

        modelAndView.setViewName("program");
        modelMap.addAttribute("user",user);
		
        return modelAndView;
    }
	
	@RequestMapping("/register")
	public @ResponseBody ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
	     modelAndView.setViewName("register");
	     return modelAndView;
	}
	
	@PostMapping("/register")
    public @ResponseBody ModelAndView register(@RequestParam("userName") String userName,
            @RequestParam("password") String password,@RequestParam("firstName") String firstName,
            @RequestParam("city") String city,@RequestParam("lastName") String lastName,
            @RequestParam("address") String address,@RequestParam("postalCode") String postalCode
            )
    {
		User user = new User (userName,password,firstName,lastName,address,city,postalCode);
		userRepo.save(user);
        ModelAndView modelAndView = new ModelAndView();
		modelAndView .addObject("message","");
        modelAndView.setViewName("index");
		
        return modelAndView;
    }
	
	@PostMapping("/logout")
	public @ResponseBody ModelAndView logout() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","");
	     modelAndView.setViewName("index");
	     return modelAndView;
	}
	

}

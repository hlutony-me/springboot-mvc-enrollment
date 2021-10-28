package com.spring.jpa.controller;

import com.spring.jpa.model.User;
import com.spring.jpa.repository.EnrollmentRepo;
import com.spring.jpa.repository.ProgramRepo;
import com.spring.jpa.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"user"})
public class DashboardController {

    @Autowired
    private ProgramRepo programRepo;
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @GetMapping("/enrollment")
    public ModelAndView getPrograms(@ModelAttribute User user)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("enrollments",enrollmentRepo.findByCustomerId(user.getId()));
        modelAndView.addObject("userName",user.getUserName());
        modelAndView.setViewName("my_enrollment");
        return modelAndView;
    }
    
    @GetMapping("/profile")
    public ModelAndView getUserProfile(@ModelAttribute User user)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);

        modelAndView.setViewName("profile");
        return modelAndView;
    }
    
    @PostMapping("/editProfile")
    public ModelAndView editUserProfile(@RequestParam("userName") String userName,
    		@ModelAttribute User user,@RequestParam("firstName") String firstName,
            @RequestParam("city") String city,@RequestParam("lastName") String lastName,
            @RequestParam("address") String address,@RequestParam("postalCode") String postalCode
            )
    {
    	user.setAddress(address);
    	user.setCity(city);
    	user.setFirstName(firstName);
    	user.setLastName(lastName);
    	user.setPostalCode(postalCode);
    	user.setUserName(userName);
    	userRepo.save(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);

        modelAndView.setViewName("profile");
        return modelAndView;
    }
    
    @GetMapping("/editProfile")
    public ModelAndView getEditProfile(@ModelAttribute User user)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);

        modelAndView.setViewName("editProfile");
        return modelAndView;
    }
    
    @GetMapping("myEnrollment")
    public ModelAndView makePayment(@ModelAttribute User user) {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("enrollments",enrollmentRepo.findByCustomerId(user.getId()));
    	modelAndView.setViewName("my_enrollment");
    	return modelAndView;
    }


}

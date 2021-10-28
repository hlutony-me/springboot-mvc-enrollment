package com.spring.jpa.controller;

import com.spring.jpa.model.Enrollment;
import com.spring.jpa.model.Program;
import com.spring.jpa.model.User;
import com.spring.jpa.repository.EnrollmentRepo;
import com.spring.jpa.repository.ProgramRepo;
import com.spring.jpa.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@SessionAttributes({"user"})
public class ProgramController {

    @Autowired
    private ProgramRepo programRepo;

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @GetMapping("/programs")
    public ModelAndView getPrograms(@ModelAttribute User user)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("programs",programRepo.findAll());
        modelAndView.addObject("userName",user.getUserName());
        modelAndView.setViewName("program");
        return modelAndView;
    }
    
    @PostMapping("program")
    public ModelAndView createProgram(@RequestParam("programSelect") String selectedOption,@ModelAttribute User user) {
    	Program program=programRepo.findByProgramName(selectedOption);
        Enrollment enrollment = new Enrollment();
        enrollment.setProgramCode(program.getProgramCode());
        enrollment.setAmountPaid(program.getFee());
        enrollment.setCustomerId(user.getId());
        enrollment.setStatus("Paid");
        enrollment.setProgramName(program.getProgramName());
        enrollment.setStartDate(LocalDate.now());
        enrollmentRepo.save(enrollment);

    	
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("program",program);
    	modelAndView.setViewName("payment");
    	return modelAndView;
    }
    
    @PostMapping("makePayment")
    public ModelAndView makePayment(@ModelAttribute User user) {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("enrollments",enrollmentRepo.findByCustomerId(user.getId()));
    	modelAndView.setViewName("my_enrollment");
    	return modelAndView;
    }
}

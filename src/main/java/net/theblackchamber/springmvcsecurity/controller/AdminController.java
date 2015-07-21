package net.theblackchamber.springmvcsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView home() {
        return new ModelAndView("admin");
    }	
	
}

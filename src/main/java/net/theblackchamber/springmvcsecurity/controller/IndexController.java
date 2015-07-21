package net.theblackchamber.springmvcsecurity.controller;

import net.theblackchamber.springmvcsecurity.annotations.Logger;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@Logger
	private Log log;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
		log.debug("Returning Index Page");
        return new ModelAndView("index");
    }	
	
}

package com.nsp.j2ee.secure.springmvc.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nsp.j2ee.secure.springmvc.model.User;

/**
 * Handles requests for the application home page. 
 * This controller is designed
 * to handle 2 requests: “/”: the request to the application’s context root, or
 * home page. “/admin”: the request to the administrator page, which will be
 * secured by Spring security. The annotations @Controller and @RequestMapping
 * are used to declare this is a controller which has two HTTP GET handle
 * methods. These annotations will be scanned by Spring as we will configure in
 * the Spring’s application context file.
 */
@Controller
public class HelloController {
	
	final static Logger logger = Logger.getLogger(HelloController.class);	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String login(@Validated User user, Model model) {
		model.addAttribute("userName", user.getUserName());
		return "user";
	}*/
	
	@RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView visitHome() {
        return new ModelAndView("index");
    }
         
    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public ModelAndView visitAdmin() {
        ModelAndView model = new ModelAndView("admin");
        model.addObject("title", "Admministrator Control Panel");
        model.addObject("message", "This page demonstrates how to use Spring security.");
         
        return model;
    }
}
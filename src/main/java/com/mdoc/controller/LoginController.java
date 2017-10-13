package com.mdoc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mdoc.model.User;
import com.mdoc.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	User user = userService.findUserByEmail(auth.getName());
	request.getSession().setAttribute("user", user);
	mav.addObject("user", user);
	if (!(auth instanceof AnonymousAuthenticationToken)) {
	    mav.setViewName("/admin/home");
	    return mav;
	}
	mav.setViewName("login");
	return mav;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
	ModelAndView mav = new ModelAndView();
	User user = new User();
	mav.addObject("user", user);
	mav.setViewName("registration");
	return mav;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindResult) {
	ModelAndView mav = new ModelAndView();
	User userExists = userService.findUserByEmail(user.getEmail());

	if (userExists != null) {
	    bindResult.rejectValue("email", "error.user", "User already exists with Email id");
	}

	if (bindResult.hasErrors()) {
	    mav.setViewName("registration");
	} else {
	    userService.saveUser(user);
	    mav.addObject("successMessage", "User registered successfully!!");
	    mav.addObject("user", new User());
	    mav.setViewName("registration");
	}
	return mav;
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	User user = userService.findUserByEmail(auth.getName());
	mav.addObject("user", user);
	mav.addObject("adminMessage", "ADMIN is available to admin roles!!");
	mav.setViewName("/admin/home");
	return mav;

    }

}

package com.mdoc.controller;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mdoc.model.User;
import com.mdoc.service.UserService;
import com.mdoc.utility.Utilities;

/**
 * This controller will provide the basic operations fo users. Like
 * signing-in,registering a new user.
 * 
 * @author navinkumark
 *
 */
@Controller
public class LoginController {

    private static final Log log = LogFactory.getLog(LoginController.class);
	
    @Autowired
    private UserService userService;
    Properties properties;

    /**
     * This method opens up the login page if user is not authenticated
     * otherwise redirects the user to admin home page.
     * 
     * @param request
     * @return ModelAndView
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView mav, HttpServletRequest request) {
    	log.info("~~~~~~~~~~~Login Form~~~~~~~~~~~");
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	properties = new Utilities().loadProperties();
    	User user = userService.findUserByEmail(auth.getName());
    	request.getSession().setAttribute("user", user);
    	mav.addObject("user", user);
    	if (!(auth instanceof AnonymousAuthenticationToken)) {
    		/*mav.addObject("appName", properties.getProperty("appName"));
	    	mav.addObject("copyRight", properties.getProperty("copyRight"));*/
    		mav.setViewName("/admin/home");
    		return mav;
    	}
    	//mav.addObject("appName", properties.getProperty("appName"));
    	mav.setViewName("login");
    	return mav;
    }

    /**
     * Opens the registration page to register a new user.
     * 
     * @return ModelAndView
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(ModelAndView mav) {
    	log.info("~~~~~~~~~~Registration Form~~~~~~~~~~~~");
    	User user = new User();
    	mav.addObject("user", user);
    	/*mav.addObject("appName", properties.getProperty("appName"));
		mav.addObject("copyRight", properties.getProperty("copyRight"));*/
    	mav.setViewName("registration");
    	return mav;
    }

    /**
     * Gets the form input from registration page and adds the user to the
     * database.
     * 
     * @param user
     * @param bindResult
     * @return ModelAndView
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(ModelAndView mav, @Valid User user, BindingResult bindResult) {
    	log.info("~~~~~~~~~~~~Registration Save~~~~~~~~~~~~~");
    	User userExists = userService.findUserByEmail(user.getEmail());

    	if (userExists != null) {
    		bindResult.rejectValue("email", "error.user", "User already exists with Email id");
    	}

    	if (bindResult.hasErrors()) {
    		/*mav.addObject("appName", properties.getProperty("appName"));
	    	mav.addObject("copyRight", properties.getProperty("copyRight"));*/
    		mav.setViewName("registration");
    	} else {
    		userService.saveUser(user);
    		mav.addObject("successMessage", "User registered successfully!!");
    		/*mav.addObject("user", new User());
	    	mav.setViewName("registration");*/
    		mav.setView(new RedirectView("/docs-app/admin/home"));
    	}
    	return mav;
    }

    /**
     * Shows the admin page after user authentication is done.
     * 
     * @param ModelAndView
     * @return ModelAndView
     */
    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView mav) {
    	log.info("~~~~~~~~~~~Admin Home~~~~~~~~~~~");
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	//properties = new Utilities().loadProperties();
    	User user = userService.findUserByEmail(auth.getName());
    	mav.addObject("user", user);
    	/*mav.addObject("appName", properties.getProperty("appName"));
		mav.addObject("copyRight", properties.getProperty("copyRight"));*/
    	mav.setViewName("/admin/home");
    	return mav;

    }

}

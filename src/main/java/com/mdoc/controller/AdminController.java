package com.mdoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mdoc.model.User;
import com.mdoc.service.UserService;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/admin/change-password", method = RequestMethod.GET)
    public ModelAndView changePasswordForm() {
	ModelAndView mav = new ModelAndView();
	
	mav.setViewName("/admin/changePassword");
	return mav;
    }

    @RequestMapping(value = "/admin/change-password", method = RequestMethod.POST)
    public ModelAndView changePasswordSubmit(@RequestParam("currentPassword") String current_password,
	    @RequestParam("newPassword") String new_password) {
	ModelAndView mav = new ModelAndView();
	BCryptPasswordEncoder bCryptPassEncoder = new BCryptPasswordEncoder();
	String username = SecurityContextHolder.getContext().getAuthentication().getName();
	User user = userService.findUserByEmail(username);
	String encodedPassword = user.getPassword();
	if (!bCryptPassEncoder.matches(current_password, encodedPassword)) {
	    mav.addObject("successMessage", "Current Password entered is wrong!!!");
	    mav.setView(new RedirectView("../admin/change-password"));
	    return mav;
	}
	user.setPassword(new_password);
	userService.saveUser(user);
	mav.addObject("successMessage", "Password changed Successfully!!!");
	mav.setView(new RedirectView("../admin/home"));
	return mav;
    }
    
    @RequestMapping(value="/admin/manage-users",method=RequestMethod.GET)
    public ModelAndView showManageUsers() {
	ModelAndView mav = new ModelAndView();
	List<User> userList = userService.getUsers();
	/*for (User user : userList) {
	    System.out.println(user.getName());
	}*/
	mav.addObject("users", userList);
	mav.setViewName("/admin/manageUsers");
	return mav;
    }

    @RequestMapping(value = "/admin/manage-users/{action}/{id}")
    public ModelAndView manageUsers(@PathVariable("action") String action, @PathVariable("id") int id) {
	ModelAndView mav = new ModelAndView();
	if (action.equals("edit")) {
	    mav.setView(new RedirectView("/docs-app/admin/manage-users"));
	} else if (action.equals("delete")) {
	    userService.deleteUser(id);
	    mav.addObject("successMessage", "User removed successfully!!");
	    mav.setView(new RedirectView("/docs-app/admin/manage-users"));
	} else if (action.equals("block")) {
	    userService.blockUser(id);
	    mav.addObject("successMessage", "User blocked successfully!!");
	    mav.setView(new RedirectView("/docs-app/admin/manage-users"));
	} else if (action.equals("unblock")) {
	    userService.unBlockUser(id);
	    mav.addObject("successMessage", "User is active now!!");
	    mav.setView(new RedirectView("/docs-app/admin/manage-users"));
	}
	return mav;
    }
}

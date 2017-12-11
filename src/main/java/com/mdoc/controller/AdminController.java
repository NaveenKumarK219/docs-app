package com.mdoc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mdoc.model.TableOfContents;
import com.mdoc.model.User;
import com.mdoc.repository.DocumentRepository;
import com.mdoc.service.DocumentService;
import com.mdoc.service.UserService;
import com.mdoc.utility.Utilities;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    DocumentService documentService;
    @Autowired
    DocumentRepository documentRepository;

    Properties properties = new Utilities().loadProperties();

    @RequestMapping(value = "/admin/change-password", method = RequestMethod.GET)
    public ModelAndView changePasswordForm(ModelAndView mav) {

	mav.addObject("appName", properties.getProperty("appName"));
	mav.addObject("copyRight", properties.getProperty("copyRight"));
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
    public ModelAndView showManageUsers(ModelAndView mav) {

	List<User> userList = userService.getUsers();
	mav.addObject("users", userList);
	mav.addObject("appName", properties.getProperty("appName"));
	mav.addObject("copyRight", properties.getProperty("copyRight"));
	mav.setViewName("/admin/manageUsers");
	return mav;
    }

    @RequestMapping(value = "/admin/manage-users/{action}/{id}", method = RequestMethod.GET)
    public ModelAndView manageUsers(ModelAndView mav, @PathVariable("action") String action,
	    @PathVariable("id") int id) {

	User user = null;
	if (action.equals("edit")) {
	    user = userService.getUserById(id);
	    mav.addObject("user", user);
	    mav.addObject("appName", properties.getProperty("appName"));
	    mav.addObject("copyRight", properties.getProperty("copyRight"));
	    mav.setViewName("/admin/editUser");

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
    
    @RequestMapping(value = "/admin/manage-users/save-user-edit", method = RequestMethod.POST)
    public ModelAndView saveUserEdit(ModelAndView mav, @Valid User user, BindingResult bindResult) {

	User userExists = userService.findUserByEmail(user.getEmail());
	User updateUser = userService.getUserById(user.getId());

	if (userExists != null && !user.getEmail().equals(updateUser.getEmail())) {
	    bindResult.rejectValue("email", "error.user", "User already exists with Email id");
	}

	if (bindResult.hasErrors()) {
	    mav.addObject("errorField", bindResult.getFieldError().getField());
	    mav.addObject("errorMessage", bindResult.getFieldError().getDefaultMessage());
	    mav.setView(new RedirectView("/docs-app/admin/manage-users/edit/" + user.getId() + ""));
	} else {
	    updateUser.setName(user.getName());
	    updateUser.setLastName(user.getLastName());
	    updateUser.setEmail(user.getEmail());
	    updateUser.setPassword(user.getPassword());
	    updateUser.setRole(user.getRole());
	    userService.saveUser(updateUser);
	    mav.addObject("successMessage", "User Details updated successfully!!");
	    mav.setView(new RedirectView("/docs-app/admin/manage-users"));
	}

	return mav;
    }

    @RequestMapping(value = "/admin/app-settings", method = RequestMethod.GET)
    public ModelAndView appSettings(ModelAndView mav) {

	mav.addObject("appName", properties.getProperty("appName"));
	mav.addObject("copyRight", properties.getProperty("copyRight"));
	mav.setViewName("/admin/appSettings");
	return mav;
    }

    @RequestMapping(value = "/admin/app-settings", method = RequestMethod.POST)
    public ModelAndView saveSettings(@RequestParam("doc-app-name") String docAppName,
	    @RequestParam("copy-right") String copyright) {
	ModelAndView mav = new ModelAndView();
	Utilities util = new Utilities();
	HashMap<String, String> propHash = new HashMap<>();
	propHash.put("appName", docAppName);
	propHash.put("copyRight", copyright);
	util.saveProperties(propHash);
	properties = new Utilities().loadProperties();
	mav.addObject("successMessage", "App settings applied successfully!!");
	mav.setView(new RedirectView("../admin/home"));
	return mav;
    }

    @RequestMapping(value = "/admin/manage-docs", method = RequestMethod.GET)
    public ModelAndView getAllDocs(ModelAndView mav) {
	// ModelAndView mav = new ModelAndView();
	List<TableOfContents> tocList = documentRepository.findAllByOrderById();
	mav.addObject("tocList", tocList);
	mav.addObject("appName", properties.getProperty("appName"));
	mav.addObject("copyRight", properties.getProperty("copyRight"));
	mav.setViewName("/admin/docsListView");

	return mav;
    }

    @RequestMapping(value = "/admin/manage-docs/{action}/{title}", method = RequestMethod.GET)
    public ModelAndView manageDocs(ModelAndView mav, @PathVariable("action") String action,
	    @PathVariable("title") String title) {
	TableOfContents toc = documentService.getTableOfContentsOnTitle(title);
	if (action.equals("hide")) {
	    toc.setActive(false);
	    documentService.saveTableOfContents(toc);
	    mav.addObject("successMessage", title + " doc is now hidden in app menu!");
	} else if (action.equals("show")) {
	    toc.setActive(true);
	    documentService.saveTableOfContents(toc);
	    mav.addObject("successMessage", title + " is visible in the app menu now!");
	}
	mav.setView(new RedirectView("/docs-app/admin/manage-docs"));
	return mav;
    }
}

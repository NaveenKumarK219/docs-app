package com.mdoc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

	private static final Log log = LogFactory.getLog(AdminController.class);
	private static final String MANAGE_USERS_LINK = "/docs-app/admin/manage-users";
	private static final String SUCCESS_MESSAGE = "successMessage";
	private static final String ACTION_EDIT = "edit";
	private static final String ACTION_DELETE = "delete";
	private static final String ACTION_BLOCK = "block";
	private static final String ACTION_UNBLOCK = "unblock";
	private static final String ACTION_HIDE = "hide";
	private static final String ACTION_SHOW = "show";
	
	@Autowired
	UserService userService;
	@Autowired
	DocumentService documentService;
	@Autowired
	DocumentRepository documentRepository;
	Properties properties;
	
	// Change Password Functionality
	@RequestMapping(value = "/admin/change-password", method = RequestMethod.GET)
	public ModelAndView changePasswordForm(ModelAndView mav) {

		log.info("~~~~~~~~Change Password Form~~~~~~~~");
		mav.setViewName("/admin/changePassword");
		return mav;
	}

	@RequestMapping(value = "/admin/change-password", method = RequestMethod.POST)
	public ModelAndView changePasswordSubmit(@RequestParam("currentPassword") String currentPassword,
			@RequestParam("newPassword") String newPassword) {
		log.info("~~~~~~~~~Change Password Submit~~~~~~~~~");
		ModelAndView mav = new ModelAndView();
		BCryptPasswordEncoder bCryptPassEncoder = new BCryptPasswordEncoder();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findUserByEmail(username);
		String encodedPassword = user.getPassword();
		if (!bCryptPassEncoder.matches(currentPassword, encodedPassword)) {
			mav.addObject(SUCCESS_MESSAGE, "Current Password entered is wrong!!!");
			mav.setView(new RedirectView("../admin/change-password"));
			return mav;
		}
		user.setPassword(newPassword);
		userService.saveUser(user);
		mav.addObject(SUCCESS_MESSAGE, "Password changed Successfully!!!");
		mav.setView(new RedirectView("../admin/home"));
		return mav;
	}

	// User Managing Functionality
	@RequestMapping(value="/admin/manage-users",method=RequestMethod.GET)
	public ModelAndView showManageUsers(ModelAndView mav) {
		log.info("~~~~~~~~Manage Users Form~~~~~~~~~~");
		List<User> userList = userService.getUsers();
		mav.addObject("users", userList);
		mav.setViewName("/admin/manageUsers");
		return mav;
	}

	@RequestMapping(value = "/admin/manage-users/{action}/{id}", method = RequestMethod.GET)
	public ModelAndView manageUsers(ModelAndView mav, @PathVariable("action") String action,
			@PathVariable("id") int id) {
		log.info("~~~~~~~~~~Manage Users Action~~~~~~~~~");
		User user = null;
		if (ACTION_EDIT.equalsIgnoreCase(action)) {
			user = userService.getUserById(id);
			mav.addObject("user", user);
			mav.setViewName("/admin/editUser");

		} else if (ACTION_DELETE.equalsIgnoreCase(action)) {
			userService.deleteUser(id);
			mav.addObject(SUCCESS_MESSAGE, "User removed successfully!!");
			mav.setView(new RedirectView(MANAGE_USERS_LINK));
		} else if (ACTION_BLOCK.equalsIgnoreCase(action)) {
			userService.blockUser(id);
			mav.addObject(SUCCESS_MESSAGE, "User blocked successfully!!");
			mav.setView(new RedirectView(MANAGE_USERS_LINK));
		} else if (ACTION_UNBLOCK.equalsIgnoreCase(action)) {
			userService.unBlockUser(id);
			mav.addObject(SUCCESS_MESSAGE, "User is active now!!");
			mav.setView(new RedirectView(MANAGE_USERS_LINK));
		}
		return mav;
	}

	@RequestMapping(value = "/admin/manage-users/save-user-edit", method = RequestMethod.POST)
	public ModelAndView saveUserEdit(ModelAndView mav, @Valid User user, BindingResult bindResult) {
		log.info("~~~~~~~~~~~Save User Edit~~~~~~~~~~~~~");
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
			mav.addObject(SUCCESS_MESSAGE, "User Details updated successfully!!");
			mav.setView(new RedirectView(MANAGE_USERS_LINK));
		}

		return mav;
	}

	// Application Settings Functionality
	@RequestMapping(value = "/admin/app-settings", method = RequestMethod.GET)
	public ModelAndView appSettings(ModelAndView mav) {
		log.info("~~~~~~~~App Settings Form~~~~~~~~~~");
		mav.setViewName("/admin/appSettings");
		return mav;
	}

	@RequestMapping(value = "/admin/app-settings", method = RequestMethod.POST)
	public ModelAndView saveSettings(@RequestParam("doc-app-name") String docAppName,
			@RequestParam("copy-right") String copyright) throws IOException {
		log.info("~~~~~~~~~~App Settings Save~~~~~~~~~~~");
		ModelAndView mav = new ModelAndView();
		Utilities util = new Utilities();
		Map<String, String> propHash = new HashMap<>();
		propHash.put("appName", docAppName);
		propHash.put("copyRight", copyright);
		util.saveProperties(propHash);
		properties = new Utilities().loadProperties();
		mav.addObject(SUCCESS_MESSAGE, "App settings applied successfully!!");
		mav.setView(new RedirectView("../admin/home"));
		return mav;
	}

	// Docs Management Functionality
	@RequestMapping(value = "/admin/manage-docs", method = RequestMethod.GET)
	public ModelAndView getAllDocs(ModelAndView mav) {
		log.info("~~~~~~~~~~Manage Docs Form~~~~~~~~~~~");
		List<TableOfContents> tocList = documentRepository.findAllByOrderById();
		mav.addObject("tocList", tocList);
		mav.setViewName("/admin/docsListView");

		return mav;
	}

	@RequestMapping(value = "/admin/manage-docs/{action}/{title}", method = RequestMethod.GET)
	public ModelAndView manageDocs(ModelAndView mav, @PathVariable("action") String action,
			@PathVariable("title") String title) {
		log.info("~~~~~~~~~~Manage Docs Action~~~~~~~~~~~");
		TableOfContents toc = documentService.getTableOfContentsOnTitle(title);
		if (ACTION_HIDE.equalsIgnoreCase(action)) {
			toc.setActive(false);
			documentService.saveTableOfContents(toc);
			mav.addObject(SUCCESS_MESSAGE, title + " doc is now hidden in app menu!");
		} else if (ACTION_SHOW.equalsIgnoreCase(action)) {
			toc.setActive(true);
			documentService.saveTableOfContents(toc);
			mav.addObject(SUCCESS_MESSAGE, title + " is visible in the app menu now!");
		}
		mav.setView(new RedirectView("/docs-app/admin/manage-docs"));
		return mav;
	}
}

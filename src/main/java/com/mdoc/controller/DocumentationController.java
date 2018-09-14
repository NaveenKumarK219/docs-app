package com.mdoc.controller;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mdoc.model.AppProperties;
import com.mdoc.model.TableOfContents;
import com.mdoc.service.DocumentService;
import com.mdoc.utility.Utilities;

/**
 * This class is a controller which contains the main functionality of the
 * application. Here following operations are performed: View, Add, Edit and Save.
 * 
 * @author navinkumark
 *
 */
@Controller
@SessionAttributes("appProperties")
public class DocumentationController {

	private static final Log log = LogFactory.getLog(DocumentationController.class);
	private static final String FILEPATH = System.getenv("HOME") + "/docs";
	private static final String VIEW_DOCUMENT = "viewDoc";
	private static final String MARKDOWN_HTML = "markdownHtml";
	private static final String TITLE = "title";
	private static final String HOME_FILE = "/home.md";

	@Autowired
	private DocumentService documentService;
	Properties properties;
	Authentication auth;

	@ModelAttribute("appProperties")
	public AppProperties loadProperties(AppProperties appProp) {
		properties = new Utilities().loadProperties();
		appProp.setAppName(properties.getProperty("appName", "Documentation App"));
		appProp.setCopyRight(properties.getProperty("copyRight", "&copy; 2017 Docs App . All Rights Reserved"));
		log.info("~~~~~~~~~~Properties Loaded~~~~~~~~~~~");
		return appProp;
	}
	
	/**
	 * This method is called after the application is started. It will give the
	 * welcome page for the application.
	 * 
	 * @param session
	 * @return ModelAndView
	 * @throws IOException
	 */
	@RequestMapping(value = { "/docs", "/" }, method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mav, HttpSession session) throws IOException {
		log.info("~~~~~~~~~~~Docs Home~~~~~~~~~~~");
		File directory = new File(FILEPATH);
		if (!directory.exists()) {
			directory.mkdir();
		}
		File file = null;
		List<TableOfContents> tocList = documentService.getTableOfContents();
		String htmlContent = null;
		if (tocList.isEmpty()) {
			mav.setViewName(VIEW_DOCUMENT);
			htmlContent = documentService.markdownToHtmlConverter("welcomePage", session.getServletContext().getRealPath("WEB-INF/classes/markdown"));
			mav.addObject(MARKDOWN_HTML, htmlContent);
			mav.addObject(TITLE, "Get Started");
			return mav;
		}
		file = new File(FILEPATH + HOME_FILE);
		if(file.exists())
			htmlContent = documentService.markdownToHtmlConverter("home", FILEPATH);
		else
			htmlContent = documentService.markdownToHtmlConverter("home", session.getServletContext().getRealPath("WEB-INF/classes/markdown"));
		mav.addObject(MARKDOWN_HTML, htmlContent);
		mav.addObject("tocList", tocList);
		mav.addObject(TITLE, "Home");
		mav.setViewName(VIEW_DOCUMENT);
		return mav;

	}

	/**
	 * With this method we view the docs. Using the title provided in the url,
	 * this method gets the markdown file and converts it into html and
	 * redirects to view the page.
	 * 
	 * @param title
	 * @param session
	 * @return ModelAndView
	 * @throws IOException
	 */
	@RequestMapping(value = "/docs/{title}", method = RequestMethod.GET)
	public ModelAndView viewDocument(ModelAndView mav, @PathVariable String title, HttpSession session)
			throws IOException {
		log.info("~~~~~~~~~~View Doc : "+title+"~~~~~~~~~~~~");
		auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = null;
		if (auth != null) {
			userName = auth.getName();
		}
		List<TableOfContents> tocList = documentService.getTableOfContents();
		TableOfContents toc = documentService.getTableOfContentsOnTitle(title);
		String fileName = documentService.getDocFileName(title);
		if (fileName == null)
			fileName = "home";

		String htmlContent = documentService.markdownToHtmlConverter(fileName, FILEPATH);

		mav.addObject(MARKDOWN_HTML, htmlContent);
		mav.addObject("tocList", tocList);
		mav.addObject("toc", toc);
		mav.addObject(TITLE, title);
		mav.addObject("userName", userName);
		mav.setViewName(VIEW_DOCUMENT);
		return mav;
	}

	/**
	 * This will open up the new doc page to create a new document.
	 * 
	 * @return ModelAndView
	 * @throws IOException
	 */
	@RequestMapping(value = "/admin/newDoc")
	public ModelAndView newDocument(ModelAndView mav) {
		log.info("~~~~~~~~~~~New Doc Form~~~~~~~~~~~~~");
		auth = SecurityContextHolder.getContext().getAuthentication();
		mav.setViewName("/admin/createNewDoc");

		return mav;
	}

	/**
	 * This method gets the document contents from the new doc page and writes
	 * the markdown content to a file.
	 * 
	 * @param session
	 * @param title
	 * @param markdownText
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/admin/addNewDoc", method = RequestMethod.POST)
	public ModelAndView addNewDocument(HttpSession session, @RequestParam("title") String title,
			@RequestParam("markdownText") String markdownText) {
		log.info("~~~~~~~~~~~New Doc Save~~~~~~~~~~~~~");
		ModelAndView mav = new ModelAndView();
		TableOfContents toc = new TableOfContents();
		String fileName = title.trim().replaceAll("\\s{1,}", "-");
		log.info("Title: " + title + " File Name: " + fileName);

		try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(FILEPATH + "/" + fileName + ".md"))) {
			bWriter.write(markdownText);
			toc.setTitle(title);
			toc.setFileName(fileName);
			toc.setAuthor(auth.getName());
			toc.setCreatedDtm(Calendar.getInstance().getTime());
			toc.setActive(true);
			documentService.setTableOfContents(toc);
		} catch (IOException e) {

			log.error(e.getMessage(), e);
		}
		mav.addObject(TITLE, title);
		mav.addObject("successMessage", " Doc Added successfully!!!");
		mav.setView(new RedirectView("../admin/home"));
		return mav;
	}

	/**
	 * This will open up the edit page for the document with content loaded and
	 * ready for edit.
	 * 
	 * @param session
	 * @param title
	 * @return ModelAndView
	 * @throws IOException
	 */
	@RequestMapping(value = "/admin/editDoc/{title}", method = RequestMethod.GET)
	public ModelAndView editDocument(ModelAndView mav, HttpSession session, @PathVariable("title") String title)
			throws IOException {
		log.info("~~~~~~~~~~~Edit Doc :"+title+"~~~~~~~~~~~");
		auth = SecurityContextHolder.getContext().getAuthentication();
		String fileName = documentService.getDocFileName(title);
		if (fileName == null)
			fileName = "home";
		DataInputStream dis = null;
		File file = new File(FILEPATH + HOME_FILE);
		if (fileName.equals("home") && !file.exists())
			dis = new DataInputStream(new FileInputStream(session.getServletContext().getRealPath("WEB-INF/classes/markdown/home.md")));
		else
			dis = new DataInputStream(new FileInputStream(FILEPATH + "/" + fileName + ".md"));

		byte[] markdownByte = null;
		try {
			markdownByte = new byte[dis.available()];
			dis.readFully(markdownByte);
			dis.close();
		} catch (IOException e) {
			log.info(e.getMessage(), e);
		} finally {
			dis.close();
		}

		String markdownText = new String(markdownByte);
		mav.addObject(TITLE, title);
		mav.addObject("markdownText", markdownText);
		mav.setViewName("/admin/editDoc");
		return mav;
	}

	/**
	 * Here the edited doc contents are saved and published.
	 * 
	 * @param session
	 * @param title
	 * @param markdownText
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/admin/saveDoc", method = RequestMethod.POST)
	public ModelAndView saveDocument(ModelAndView mav, HttpSession session, @RequestParam("title") String title,
			@RequestParam("markdownText") String markdownText) throws IOException {
		log.info("~~~~~~~~~~~Save Doc : "+title+"~~~~~~~~~~~");
		File file = new File(FILEPATH + HOME_FILE);
		if(file.createNewFile()) {
			log.info("~~~~~New File created : "+ file.getName()+"~~~~~~");
		}
		String fileName = documentService.getDocFileName(title);
		if (fileName == null)
			fileName = "home";
		log.info("Title: " + title + " File Name: " + fileName);
		TableOfContents toc = documentService.getTableOfContentsOnTitle(title);

		try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(FILEPATH + "/" + fileName + ".md"))) {
			bWriter.write(markdownText);
		} catch (IOException e) {

			log.info(e.getMessage(), e);
		}
		if (toc != null) {
			toc.setEditedBy(auth.getName());
			toc.setEditedDtm(Calendar.getInstance().getTime());
			documentService.setTableOfContents(toc);
		}
		mav.addObject(TITLE, title);
		mav.addObject("successMessage", " Doc Edited successfully!!!");
		mav.setView(new RedirectView("../admin/home"));
		return mav;
	}

}

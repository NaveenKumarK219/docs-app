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
@SessionAttributes("modelAndView")
public class DocumentationController {

	private static final Log log = LogFactory.getLog(DocumentationController.class);
	private final String filePath = System.getenv("HOME") + "/docs";

	@Autowired
	private DocumentService documentService;

	Properties properties = new Utilities().loadProperties();

	Authentication auth;

	@ModelAttribute("modelAndView")
	public ModelAndView loadProperties(ModelAndView mav) {

		//properties = new Utilities().loadProperties();
		mav.addObject("appName", properties.getProperty("appName"));
		mav.addObject("copyRight", properties.getProperty("copyRight"));
		log.info("~~~~~~~Properties Loaded!~~~~~~~~~");
		return mav;
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
	public ModelAndView home(@ModelAttribute("modelAndView") ModelAndView mav, HttpSession session) throws IOException {
		log.info("~~~~~~~~~~~Docs Home~~~~~~~~~~~");
		File directory = new File(filePath);
		if (!directory.exists()) {
			directory.mkdir();
		}
		File file = null;
		//properties = new Utilities().loadProperties();
		List<TableOfContents> tocList = documentService.getTableOfContents();
		String htmlContent = null;
		if (tocList.size() == 0) {
			mav.setViewName("viewDoc");
			htmlContent = documentService.markdownToHtmlConverter("welcomePage", session.getServletContext().getRealPath("WEB-INF/classes/markdown"), session);
			mav.addObject("markdownHtml", htmlContent);
			mav.addObject("title", "Get Started");
			return mav;
		}
		file = new File(filePath+"/home.md");
		if(file.exists())
			htmlContent = documentService.markdownToHtmlConverter("home", filePath, session);
		else
			htmlContent = documentService.markdownToHtmlConverter("home", session.getServletContext().getRealPath("WEB-INF/classes/markdown"), session);
		mav.addObject("markdownHtml", htmlContent);
		mav.addObject("tocList", tocList);
		mav.addObject("title", "Home");
		/*mav.addObject("appName", properties.getProperty("appName"));
		mav.addObject("copyRight", properties.getProperty("copyRight"));*/
		mav.setViewName("viewDoc");
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
	public ModelAndView viewDocument(@ModelAttribute("modelAndView") ModelAndView mav, @PathVariable String title, HttpSession session)
			throws IOException {
		log.info("~~~~~~~~~~View Doc : "+title+"~~~~~~~~~~~");
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

		String htmlContent = documentService.markdownToHtmlConverter(fileName, filePath, session);

		mav.addObject("markdownHtml", htmlContent);
		mav.addObject("tocList", tocList);
		mav.addObject("toc", toc);
		mav.addObject("title", title);
		mav.addObject("userName", userName);
		/*mav.addObject("appName", properties.getProperty("appName"));
		mav.addObject("copyRight", properties.getProperty("copyRight"));*/
		mav.setViewName("viewDoc");
		return mav;
	}

	/**
	 * This will open up the new doc page to create a new document.
	 * 
	 * @return ModelAndView
	 * @throws IOException
	 */
	@RequestMapping(value = "/admin/newDoc")
	public ModelAndView newDocument(@ModelAttribute("modelAndView") ModelAndView mav) throws IOException {
		log.info("~~~~~~~~~~~New Doc Form~~~~~~~~~~~~~");
		auth = SecurityContextHolder.getContext().getAuthentication();
		/*mav.addObject("appName", properties.getProperty("appName"));
		mav.addObject("copyRight", properties.getProperty("copyRight"));*/
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
		System.out.println("Title: " + title + " File Name: " + fileName);

		try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath + "/" + fileName + ".md"))) {
			bWriter.write(markdownText);
			toc.setTitle(title);
			toc.setFileName(fileName);
			toc.setAuthor(auth.getName());
			toc.setCreated_dtm(Calendar.getInstance().getTime());
			toc.setActive(true);
			documentService.setTableOfContents(toc);
		} catch (IOException e) {

			e.printStackTrace();
		}
		mav.addObject("title", title);
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
	public ModelAndView editDocument(@ModelAttribute("modelAndView") ModelAndView mav, HttpSession session, @PathVariable("title") String title)
			throws IOException {
		log.info("~~~~~~~~~~~Edit Doc :"+title+"~~~~~~~~~~~");
		auth = SecurityContextHolder.getContext().getAuthentication();
		String fileName = documentService.getDocFileName(title);
		if (fileName == null)
			fileName = "home";
		DataInputStream dis = null;
		File file = new File(filePath+"/home.md");
		if (fileName.equals("home") && !file.exists())
			dis = new DataInputStream(new FileInputStream(session.getServletContext().getRealPath("WEB-INF/classes/markdown/home.md")));
		else
			dis = new DataInputStream(new FileInputStream(filePath + "/" + fileName + ".md"));

		byte[] markdownByte = null;
		try {
			markdownByte = new byte[dis.available()];
			dis.readFully(markdownByte);
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String markdownText = new String(markdownByte);
		mav.addObject("title", title);
		mav.addObject("markdownText", markdownText);
		/*mav.addObject("appName", properties.getProperty("appName"));
		mav.addObject("copyRight", properties.getProperty("copyRight"));*/
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
		File file = new File(filePath + "/home.md");
		file.createNewFile();
		String fileName = documentService.getDocFileName(title);
		if (fileName == null)
			fileName = "home";
		System.out.println("Title: " + title + " File Name: " + fileName);
		TableOfContents toc = documentService.getTableOfContentsOnTitle(title);

		try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath + "/" + fileName + ".md"))) {
			bWriter.write(markdownText);
		} catch (IOException e) {

			e.printStackTrace();
		}
		if (toc != null) {
			toc.setEdited_by(auth.getName());
			toc.setEdited_dtm(Calendar.getInstance().getTime());
			documentService.setTableOfContents(toc);
		}
		mav.addObject("title", title);
		mav.addObject("successMessage", " Doc Edited successfully!!!");
		mav.setView(new RedirectView("../admin/home"));
		return mav;
	}

}

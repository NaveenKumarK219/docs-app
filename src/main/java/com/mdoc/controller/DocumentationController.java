package com.mdoc.controller;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mdoc.model.TableOfContents;
import com.mdoc.service.DocumentService;

@Controller
public class DocumentationController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = { "/docs", "/" }, method = RequestMethod.GET)
    public ModelAndView home(HttpSession session) throws IOException {
	ModelAndView mav = new ModelAndView();
	List<TableOfContents> tocList = documentService.getTableOfContents();

	String htmlContent = documentService.markdownToHtmlConverter("home", session);
	mav.addObject("markdownHtml", htmlContent);
	mav.addObject("toc", tocList);
	mav.addObject("title", "Home");
	mav.setViewName("viewDoc");
	return mav;
    }

    @RequestMapping(value = "/docs/{title}", method = RequestMethod.GET)
    public ModelAndView viewDocument(@PathVariable String title, HttpSession session) throws IOException {
	ModelAndView mav = new ModelAndView();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String userName = null;
	if (auth != null) {
	    userName = auth.getName();
	}
	List<TableOfContents> tocList = documentService.getTableOfContents();
	String fileName = documentService.getDocFileName(title);

	String htmlContent = documentService.markdownToHtmlConverter(fileName, session);
	
	mav.addObject("markdownHtml", htmlContent);
	mav.addObject("toc", tocList);
	mav.addObject("title", title);
	mav.addObject("userName", userName);
	mav.setViewName("viewDoc");
	return mav;
    }

    @RequestMapping(value = "/admin/newDoc")
    public ModelAndView newDocument() throws IOException {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("/admin/createNewDoc");

	return mav;
    }

    @RequestMapping(value = "/admin/addNewDoc", method = RequestMethod.POST)
    public ModelAndView addNewDocument(HttpSession session, @RequestParam("title") String title,
	    @RequestParam("markdownText") String markdownText) {

	ModelAndView mav = new ModelAndView();
	TableOfContents toc = new TableOfContents();
	String fileName = title.trim().replaceAll("\\s{1,}", "-");
	System.out.println("Title: " + title + " File Name: " + fileName);

	try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(session.getServletContext().getRealPath("WEB-INF/classes/markdown/" + fileName + ".md")))){
	    bWriter.write(markdownText);
	    toc.setTitle(title);
	    toc.setFileName(fileName);
	    documentService.setTableOfContents(toc);
	} catch (IOException e) {

	    e.printStackTrace();
	}
	mav.addObject("title", title);
	mav.addObject("successMessage", " Doc Added successfully!!!");
	mav.setView(new RedirectView("../admin/home"));
	return mav;
    }

    @RequestMapping(value = "/admin/editDoc/{title}", method = RequestMethod.GET)
    public ModelAndView editDocument(HttpSession session, @PathVariable("title") String title)
	    throws FileNotFoundException {
	ModelAndView mav = new ModelAndView();
	String fileName = documentService.getDocFileName(title);
	DataInputStream dis = new DataInputStream(new FileInputStream(session.getServletContext().getRealPath("WEB-INF/classes/markdown/" + fileName + ".md")));
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
	mav.setViewName("/admin/editDoc");
	return mav;
    }

    @RequestMapping(value = "/admin/saveDoc", method = RequestMethod.POST)
    public ModelAndView saveDocument(HttpSession session, @RequestParam("title") String title,
	    @RequestParam("markdownText") String markdownText) {
	ModelAndView mav = new ModelAndView();
	String fileName = documentService.getDocFileName(title);
	System.out.println("Title: " + title + " File Name: " + fileName);

	try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(session.getServletContext().getRealPath("WEB-INF/classes/markdown/" + fileName + ".md")))){
	    bWriter.write(markdownText);
	} catch (IOException e) {

	    e.printStackTrace();
	}
	mav.addObject("title", title);
	mav.addObject("successMessage", " Doc Edited successfully!!!");
	// mav.setViewName("/admin/home");
	mav.setView(new RedirectView("../admin/home"));
	return mav;
    }

}

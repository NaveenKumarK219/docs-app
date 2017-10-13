package com.mdoc.service;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdoc.model.TableOfContents;
import com.mdoc.repository.DocumentRepository;

@Service("documentService")
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public List<TableOfContents> getTableOfContents() {

	/*if (title == null || title.equals("")) {
	    return documentRepository.getTableOfContents("Home");
	}*/
	return documentRepository.getTableOfContents();
    }
    
    public String getDocFileName(String title) {
	
	return documentRepository.getDocFileName(title);
    }

    public void setTableOfContents(TableOfContents toc) {
	documentRepository.save(toc);
    }

    public String markdownToHtmlConverter(String fileName) throws FileNotFoundException {

	PegDownProcessor pegdown = new PegDownProcessor(Extensions.ALL);
	DataInputStream dis = new DataInputStream(new FileInputStream("./src/main/resources/markdown/" + fileName + ".md"));
	byte[] markdownByte = null;
	try {
	    markdownByte = new byte[dis.available()];
	    dis.readFully(markdownByte);
	    dis.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

	String markdownText = new String(markdownByte);
	return pegdown.markdownToHtml(markdownText);
    }

}

package com.mdoc.service;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdoc.model.TableOfContents;
import com.mdoc.repository.DocumentRepository;

@Service("documentService")
public class DocumentService {
	
	private static final Log log = LogFactory.getLog(DocumentService.class);

    @Autowired
    private DocumentRepository documentRepository;
   

    public List<TableOfContents> getTableOfContents() {

    	return documentRepository.getTableOfContents();
    }
    
    public String getDocFileName(String title) {
	
    	return documentRepository.getDocFileName(title);
    }

    public void setTableOfContents(TableOfContents toc) {
    	documentRepository.save(toc);
    }

    public String markdownToHtmlConverter(String fileName, String filePath)
	    throws IOException {

	PegDownProcessor pegdown = new PegDownProcessor(Extensions.ALL, Long.MAX_VALUE);
	DataInputStream dis = new DataInputStream(new FileInputStream(filePath + "/" + fileName + ".md"));

	byte[] markdownByte = null;
	try {
	    markdownByte = new byte[dis.available()];
	    dis.readFully(markdownByte);
	} catch (IOException e) {
		log.error(e.getMessage(), e);
	}finally {
		dis.close();
	}

	String markdownText = new String(markdownByte);
	return pegdown.markdownToHtml(markdownText);
    }

    public TableOfContents getTableOfContentsOnTitle(String title) {

	return documentRepository.findByTitle(title);
    }

    public void saveTableOfContents(TableOfContents toc) {
	documentRepository.save(toc);
    }

}

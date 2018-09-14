package com.mdoc.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Utilities {

	private Logger log = Logger.getLogger(Utilities.class);
    private static final String FILEPATH = System.getenv("HOME") + "/docs";

    public Properties loadProperties() {
	Properties prop = new Properties();
	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	InputStream inStream = classLoader.getResourceAsStream("appinfo.properties");
	File file = new File(FILEPATH + "/appinfo.properties");
	FileInputStream fis = null;
	try {
	    if (file.exists()) {
		fis = new FileInputStream(file);
		prop.load(fis);
	    } else {
		prop.load(inStream);
	    }

	} catch (Exception e) {
	    log.error(e.getMessage(), e);
	}

	return prop;
    }

    public void saveProperties(Map<String, String> propHash) throws IOException {
	Properties prop = new Properties();
	File file = new File(FILEPATH + "/appinfo.properties");
	if(file.createNewFile()) {
		log.info("New File Created : "+ file.getName());
	}
	try(FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(file);) {
	    
	    prop.load(fis);
	    Iterator<String> keySet = propHash.keySet().iterator();
	    String key = null;
	    while (keySet.hasNext()) {
		key = keySet.next();
		prop.setProperty(key, propHash.get(key));
	    }
	    prop.store(fos, null);
	} catch (Exception e) {
	    log.error(e.getMessage(), e);
	}
	
    }
}

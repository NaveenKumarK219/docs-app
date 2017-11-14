package com.mdoc.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

public class Utilities {

    private final String filePath = "/home/" + System.getProperty("user.name") + "/docs";

    public Properties loadProperties() {
	Properties prop = new Properties();
	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	InputStream inStream = classLoader.getResourceAsStream("appinfo.properties");
	File file = new File(filePath + "/appinfo.properties");
	FileInputStream fis = null;
	try {
	    if (file.exists()) {
		fis = new FileInputStream(file);
		prop.load(fis);
	    } else {
		prop.load(inStream);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return prop;
    }

    public void saveProperties(HashMap<String, String> propHash) {
	Properties prop = new Properties();
	File file = new File(filePath + "/appinfo.properties");
	FileInputStream fis = null;
	FileOutputStream fos = null;
	try {
	    file.createNewFile();
	    fis = new FileInputStream(file);
	    fos = new FileOutputStream(file);
	    prop.load(fis);
	    Iterator<String> keySet = propHash.keySet().iterator();
	    String key = null;
	    while (keySet.hasNext()) {
		key = keySet.next();
		prop.setProperty(key, propHash.get(key));
		System.out.println(key);
	    }
	    prop.store(fos, null);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}

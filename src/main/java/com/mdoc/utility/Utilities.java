package com.mdoc.utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

public class Utilities {

    public Properties loadProperties() {
	Properties prop = new Properties();
	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	InputStream inStream = classLoader.getResourceAsStream("appinfo.properties");
	try {
	    prop.load(inStream);
	} catch (IOException e) {
	    e.printStackTrace();
	}

	return prop;
    }

    public void saveProperties(HashMap<String, String> propHash) {
	Properties prop = new Properties();
	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	InputStream inStream = classLoader.getResourceAsStream("appinfo.properties");
	try {
	    prop.load(inStream);
	    Iterator<String> keySet = propHash.keySet().iterator();
	    String key = null;
	    while (keySet.hasNext()) {
		key = keySet.next();
		prop.setProperty(key, propHash.get(key));
	    }
	    prop.store(new FileOutputStream("appinfo.properties"), null);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}

package com.mdoc.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.mdoc.model.AppProperties;

public class Properties {
	
	/* File path is from resources */
	public final static String app_properties = "appinfo.json";
	
	public static AppProperties getAppProperties(HttpSession session){
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream(app_properties);
		//String app_properties_file_path = session.getServletContext().getRealPath(app_properties_file_path_from_webcontent);
		AppProperties app_properties = null;
		try {
	    	Gson gson = new Gson();
	    	InputStreamReader reader = new InputStreamReader(is, "UTF-8");
			app_properties = gson.fromJson(reader,AppProperties.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return app_properties;
	}
}

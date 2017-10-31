package com.mdoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * This class is the starting point for the application. By
 * using @springBootApplication tag, spring-boot framework will refer this class
 * as the starting point, i.e execution of our application is started from here.
 * 
 * 
 * Extends SpringBootServletInitializer class which is used to build the spring
 * boot application, avoiding the tomcat bundle provided in spring-boot jar and
 * makes it available to run in other tomcat servers.
 * 
 * @author navinkumark
 * @version 2.0
 * @since Sep-2017
 */
@SpringBootApplication
public class MagmaDocAppLaunch extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

	return builder.sources(MagmaDocAppLaunch.class);
    }

    public static void main(String[] args) {
	SpringApplication.run(MagmaDocAppLaunch.class, args);
    }
}
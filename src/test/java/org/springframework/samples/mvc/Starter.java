/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package org.springframework.samples.mvc;

import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

/**
 *
 * @author tinghe
 * @version $Id: Starter.java, v 0.1 2017年10月16日 下午3:34 tinghe Exp $
 */
public class Starter {
    public static void main(String[] args) throws Exception {
        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.valueOf(webPort));

        StandardContext ctx = (StandardContext) tomcat.addWebapp("/spring-mvc-showcase", new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
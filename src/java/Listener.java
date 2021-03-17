
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author diogo11
 */
public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    
    int userCount = 0;
    ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        servletContext = sce.getServletContext();
        servletContext.setAttribute("userCounter", Integer.toString(userCount));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
    
    public void attributeAdded(HttpSessionBindingEvent event) {
        if(event.getName().equals("loggedIn")){
            userCount++;
            servletContext.setAttribute("userCounter", Integer.toString(userCount));
        }
    }
    
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if(event.getName().equals("loggedIn")){
            userCount--;
            servletContext.setAttribute("userCounter", Integer.toString(userCount));
        }
    }  
    
}

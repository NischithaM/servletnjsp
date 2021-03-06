package com.cruds.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class DemoSessionListener
 *
 */
public class DemoSessionListener implements HttpSessionListener ,HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public DemoSessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("HTTP session created  "+arg0.getSession().getId());
    
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("HTTP session destroyed");
    }

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Attribute added   " +arg0.getName() +" = " +arg0.getValue());
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("attribute removed " + arg0.getName() +" = " +arg0.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("Attribute replaced " +arg0.getName() +"=" +arg0.getValue());
		
	}
	
}



import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyRequestLinstener
 *
 */
@WebListener
public class MyRequestLinstener implements ServletRequestAttributeListener, ServletRequestListener {

    /**
     * Default constructor. 
     */
    public MyRequestLinstener() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    	System.out.println("Initialized");
    	
    		
    	 ServletRequest sr = sre.getServletRequest();

         if (sr.getRemoteAddr().startsWith("127")||sr.getRemoteAddr().startsWith("0")) {
             sr.setAttribute("isLogin", "true");
         } else {
             sr.setAttribute("isLogin", "false");
         }

    }
    
    
	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    }


	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    	
    	ServletRequest sr=srae.getServletRequest();//request拿到ServletRequest
    	Enumeration<String> attrs=sr.getAttributeNames();
    	String st="";
    	
    	while(attrs.hasMoreElements()) {
    		String x=attrs.nextElement();
    		String v=(String)sr.getAttribute(x);//v為sr.getAttribute(x) 得到的value
    		st+=x+","+v+"\n";
    		
    	}
    	System.out.println(st);
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    }
	
}

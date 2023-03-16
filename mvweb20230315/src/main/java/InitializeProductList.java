

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import model.Product;
import java.util.*;
import java.io.*;

/**
 * Application Lifecycle Listener implementation class InitializeProductList
 *
 */

public class InitializeProductList implements ServletContextListener, ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public InitializeProductList() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext context = sce.getServletContext();
		String catalogFileName = context.getInitParameter("catalogFileName");
		InputStream is = null;
		BufferedReader catReader = null;
		try {
			is = context.getResourceAsStream(catalogFileName);
			catReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			String ProductString;
			ArrayList catalog = new ArrayList();
			while ((ProductString = catReader.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(ProductString, "|");
				String code = tokens.nextToken();
				String price = tokens.nextToken();
				String quantityStr = tokens.nextToken();
				int quantity = Integer.parseInt(quantityStr);
				String description = tokens.nextToken();
				Product p = new Product(code, price, quantity, description);
				catalog.add(p);
			}
			context.setAttribute("catalog", catalog);
			context.log("The product list was initialized.");
		} catch (Exception e) {
			context.log("Parsing catalog.txt error!");
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (catReader != null) {
				try {
					catReader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
 
    }
	
}

package pt.caleia.spring;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


public class SpringApplicationInitializer implements WebApplicationInitializer {

	
	@Override
	public void onStartup( ServletContext servletContext ) throws ServletException {
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.setConfigLocation( "pt" );
		servletContext.addListener( new ContextLoaderListener( webContext ) );
	}
	
	
}


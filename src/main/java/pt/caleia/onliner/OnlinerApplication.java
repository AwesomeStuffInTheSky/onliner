package pt.caleia.onliner;


import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import pt.caleia.rest.MessageResource;


public class OnlinerApplication extends Application<Configuration> {
	
	
	public static void main( String[] args ) throws Exception {
		String[] myArgs = new String[ 2 ];
		myArgs[ 0 ] = "server";
		myArgs[ 1 ] = "onliner.yml"; //TODO
		new OnlinerApplication().run( myArgs );
	}
	
	
	@Override
    public void initialize( Bootstrap<Configuration> bootstrap ) {
		bootstrap.addBundle( new AssetsBundle( "/css", "/css", null, "css" ) );
		bootstrap.addBundle( new AssetsBundle( "/images", "/image", null, "images" ) );
		bootstrap.addBundle( new AssetsBundle( "/js", "/js", null, "js" ) );
		bootstrap.addBundle( new AssetsBundle( "/html", "/", "index.html", "html" ) );
		
		//bootstrap.addBundle( new AssetsBundle( "/images/favicon.ico", "/favicon.ico", null, "favicon" ) );
	}

	
	@Override
	public void run( Configuration configuration, Environment environment ) throws Exception {
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.setConfigLocation( "pt" );
		environment.servlets().addServletListeners( new ContextLoaderListener( webContext ) );
		webContext.refresh();
		environment.jersey().register( webContext.getBean( MessageResource.class ) );
	}

	
}


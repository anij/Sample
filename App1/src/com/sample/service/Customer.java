package com.sample.service;

import java.io.FileInputStream;
import java.net.URI;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.startup.listenser.Startup;

@Provider
@Path("/customer")
public class Customer {
	
	private static final String STR_META_FILE_RELASTIVE_PATH = "WEB-INF/classes/resources/config.properties";
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response get() throws Exception {
		
		URI objRedirectionURI = new URI(this.getRedirectionPath());
		return Response.temporaryRedirect(objRedirectionURI).build();
		
	}
	
	
	private String getRedirectionPath(){
		java.util.Properties properties = new Properties();
		String strRedirectionURL = "";
		String strFilePath = "";
		
		try {
			
			strFilePath = Startup.STR_APP_ABSOLUTE_PATH+STR_META_FILE_RELASTIVE_PATH;
			System.out.println("strFilePath: "+strFilePath);
			properties.load(new FileInputStream(strFilePath));
			strRedirectionURL = properties.getProperty("redirection_url");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return strRedirectionURL;
	}

}

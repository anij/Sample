package com.sample.service;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;

@Provider
@Path("/customer")
public class Customer {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response get() throws Exception {
		
		HashMap<String, String> hmpResponseData = new HashMap<>(); 
		Gson objGson = new Gson();
		String strResponseData = "";
		
		hmpResponseData.put("Message", "Hello World");
		strResponseData = objGson.toJson(hmpResponseData);
		
		return Response.status(200).entity(strResponseData).build();
		
	}

}

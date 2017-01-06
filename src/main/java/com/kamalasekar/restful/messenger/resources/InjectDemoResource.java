package com.kamalasekar.restful.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	
	@GET
	@Path("annotation")
	public String getParamUtilsfromannotation(@MatrixParam("number") String number,@HeaderParam("authOsign") String authOsign, @CookieParam("name") String name){
		
		return "The parameters are" +"\n" + "Matrix Parameter Number: "+number +"\n" + "Header Parameter : " + authOsign + "\n" + "Name from Cookie parameter" + name;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriinfo, @Context HttpHeaders headers){
		
		return "the context values are" + "\n" +"The Absolute URL: " + uriinfo.getAbsolutePath().toString() + "\n" + "Cokkie Info: "+ headers.getCookies().toString();
	}
	
	
}

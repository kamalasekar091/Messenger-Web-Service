package com.kamalasekar.restful.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	
	@GET
	@Path("subpath")
	public String getParamUtils(@MatrixParam("number") String number,@HeaderParam("authOsign") String authOsign, @CookieParam("name") String name){
		
		return "The parameters are" +"\n" + "Matrix Parameter Number: "+number +"\n" + "Header Parameter : " + authOsign + "\n" + "Name from Cookie parameter" + name;
	}
}

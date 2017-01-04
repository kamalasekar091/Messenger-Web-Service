package com.kamalasekar.restful.messenger.resources;

import javax.ws.rs.Path;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kamalasekar.restful.messenger.model.Message;
import com.kamalasekar.restful.messenger.service.MessageService;

@Path("messages")
public class MessageResources {
	
	MessageService objmessageservice= new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> displayMessages(){
		
		return objmessageservice.getAllMessages();
	}

}

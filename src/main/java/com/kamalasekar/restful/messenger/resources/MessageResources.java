package com.kamalasekar.restful.messenger.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.util.List;
import java.util.Map;

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
	public List<Message> getMessages() {
		return objmessageservice.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") long id){
		return objmessageservice.getMessage(id);
	}
}

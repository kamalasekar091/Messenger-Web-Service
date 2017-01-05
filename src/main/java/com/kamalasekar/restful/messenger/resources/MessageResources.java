package com.kamalasekar.restful.messenger.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kamalasekar.restful.messenger.model.Message;
import com.kamalasekar.restful.messenger.service.MessageService;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResources {
	
	
	MessageService objmessageservice= new MessageService();
	
	@GET
	public List<Message> getMessages() {
		return objmessageservice.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id){
		return objmessageservice.getMessage(id);
	}
	
	@POST
	public Message addMessage(Message message) {
		return objmessageservice.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);
		return objmessageservice.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessages(@PathParam("messageId") long id){
		
		objmessageservice.removeMessage(id);
		
	}
	
}

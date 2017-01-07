package com.kamalasekar.restful.messenger.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.kamalasekar.restful.messenger.model.Message;
import com.kamalasekar.restful.messenger.resources.bean.MessageFilterBean;
import com.kamalasekar.restful.messenger.service.MessageService;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResources {
	
	
	MessageService objmessageservice= new MessageService();
	
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterbean) {
		if (filterbean.getYear() > 0){
			return objmessageservice.getAllMessagesForYear(filterbean.getYear());
		}else if(filterbean.getStart() >=0 && filterbean.getSize() >0){
			return objmessageservice.getAllMessagesPaginated(filterbean.getStart(), filterbean.getSize());
		}else {
			return objmessageservice.getAllMessages();
		}
			
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id){
		return objmessageservice.getMessage(id);
	}
	
	@POST
	public Response addMessage(@Context UriInfo uriinfo, Message message) {
		Message returnmesage= objmessageservice.addMessage(message);
		URI uri=uriinfo.getAbsolutePathBuilder().path(String.valueOf(returnmesage.getId())).build();
		return Response.created(uri).entity(returnmesage).build();
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
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
	
}

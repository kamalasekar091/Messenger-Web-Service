package com.kamalasekar.restful.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kamalasekar.restful.messenger.database.DatabaseClass;
import com.kamalasekar.restful.messenger.model.Message;

public class MessageService {
	
	private Map<Long,Message> messages= DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1,"First Message","Kamala Sekar"));
		messages.put(2L, new Message(2,"Second Message","Kamala Sekar"));
		messages.put(3L, new Message(3,"Third Message","Kamala Sekar"));
		messages.put(4L, new Message(4,"Fourth Message","Kamala Sekar"));
	}
	
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values()); 
	}
	

	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		messages.put((long) (messages.size()+1),message);
		return message;
	}

	public Message updateMessage(Message message){
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}

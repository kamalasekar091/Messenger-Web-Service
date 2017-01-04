package com.kamalasekar.restful.messenger.service;

import java.util.ArrayList;
import java.util.List;

import com.kamalasekar.restful.messenger.model.Message;

public class MessageService {
	
	public List<Message> getAllMessages(){
		
		
		Message m1= new Message(1L,"First Message","Kamala Sekar");
		Message m2= new Message(2L,"Second Message","Kamala Sekar");
		Message m3= new Message(1L,"Third Message","Kamala Sekar");
		Message m4= new Message(1L,"Fourth Message","Kamala Sekar");
		
		List<Message> listOfMessages = new ArrayList<>();
		
		listOfMessages.add(m1);
		listOfMessages.add(m2);
		listOfMessages.add(m3);
		listOfMessages.add(m4);
		
		return listOfMessages;
		
	}

}

package com.kamalasekar.restful.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.kamalasekar.restful.messenger.model.*;

public class DatabaseClass {
	
	private static Map<Long,Message> messagemap= new HashMap<>();
	private static Map<Long,Profile> profilemap= new HashMap<>();
	
	public static Map<Long,Message> getMessages(){
		return messagemap;
	}
	
	public static Map<Long,Profile> getProfiles(){
		return profilemap;
	}


}

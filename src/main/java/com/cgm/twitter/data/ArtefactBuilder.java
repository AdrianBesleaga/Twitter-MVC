package com.cgm.twitter.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArtefactBuilder {
	
	static List<Message> messageList = new ArrayList<Message>();
	
	public static User anUser() {
		User user = new User();
		user.setName("Adrian");
		user.setLasOnline(new Date());
		user.setOnline(true);
		return user;
	}
	
	public static List<User> getFriends(){
		List<User> friends = new ArrayList<User>();
		
		User alex = new User();
		alex.setName("Alex");
		
		User daniel = new User();
		daniel.setName("Daniel");
		
		friends.add(alex);
		friends.add(daniel);
		
		return friends;
		
	}
	
	public static List<Message> getMessages(){
		return messageList;
	}

}

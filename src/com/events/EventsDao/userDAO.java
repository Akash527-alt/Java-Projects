package com.events.EventsDao;

import com.events.pojos.User;

public interface userDAO {
	boolean registerUser(User user);
	boolean loginUser(User user);
	boolean bookEvent(String username, String eventId, String eventName);
	
	

}

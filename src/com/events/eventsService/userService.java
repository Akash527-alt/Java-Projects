package com.events.eventsService;

import com.events.pojos.User;

public interface userService {
	boolean registerUser(User user);
	boolean loginUser(User user);
	boolean bookEvent(String username, String eventId, String eventName);
	

}

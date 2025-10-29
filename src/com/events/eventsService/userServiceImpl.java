package com.events.eventsService;

import com.events.EventsDao.userDAOImpl;
import com.events.EventsDao.userDAO;
import com.events.pojos.User;


public class userServiceImpl implements userService {
	
	private userDAO userDAO;
	
	public userServiceImpl(userDAO userDAO) {
		this.userDAO= userDAO;
	}

	@Override
	public boolean registerUser(User user) {
		return userDAO.registerUser(user);
	}

	@Override
	public boolean loginUser(User user) {
		return userDAO.loginUser(user);
	}

	@Override
	public boolean bookEvent(String username, String eventId, String eventName) {
		return userDAO.bookEvent(username, eventId, eventName);
	}

}

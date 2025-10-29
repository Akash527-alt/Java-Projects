package com.events.eventsController;

import com.events.EventsDao.EventDAOImpl;
import com.events.EventsDao.EventsDAO;
import com.events.EventsDao.userDAOImpl;
import com.events.EventsDao.userDAO;
import com.events.eventsService.EventsService;
import com.events.eventsService.EventsServiceImpl;
import com.events.eventsService.userService;
import com.events.eventsService.userServiceImpl;
import com.events.pojos.TicketBookings;

public class EventManagementSystem {
	public static void main(String[] args) {
		EventsDAO dao = new  EventDAOImpl(10);
		userDAOImpl userdao = new userDAOImpl(100, new TicketBookings[50]);
		userService userService = new userServiceImpl(userdao);
		EventsService service = new EventsServiceImpl(dao);
		EventsController controller = new EventsController(service,userService);
		
		
		controller.start();
		
	}
	
}

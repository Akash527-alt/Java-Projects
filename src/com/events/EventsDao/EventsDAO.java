package com.events.EventsDao;

import com.events.pojos.Event;

public interface EventsDAO {
	
	boolean addEvent(Event event);
	Event [] getAllEvents();
	boolean deleteEvent(String eventId);
	Event getEventById(String EventId);
	
	Event updateEvent(Event newEvent);
	
	
	
	

}

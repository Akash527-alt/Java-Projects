package com.events.eventsService;

import com.events.pojos.Event;

public interface EventsService {
	boolean addEvent(Event event);
	Event[] getAllEvents();
	boolean deleteEvent(String eventId);
	Event getEventById(String EventId);
	Event updateEvent(Event newEvent);
	String registerForEvent(String eventId);
}

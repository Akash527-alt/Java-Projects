package com.events.pojos;

public class TicketBookings {
	String eventId;
	String username;
	String eventName;
	
	
	
		public TicketBookings(String eventId, String username, String eventName) {
		super();
		this.eventId = eventId;
		this.username = username;
		this.eventName = eventName;
		
	}

		
		
		

		public String getEventId() {
			return eventId;
		}


		public String getUsername() {
			return username;
		}


		public String getEventName() {
			return eventName;
		}


		

		public void setEventId(String eventId) {
			this.eventId = eventId;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public void setEventName(String eventName) {
			this.eventName = eventName;
		}


		


	
		
		
		

}

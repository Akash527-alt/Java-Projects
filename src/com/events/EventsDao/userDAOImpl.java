package com.events.EventsDao;

import com.events.pojos.TicketBookings;
import com.events.pojos.User;

public class userDAOImpl implements userDAO{
	private User[] users;
	private int userCount =0;
	private TicketBookings[] bookings;
	private int bookingCount = 0;
	
	public userDAOImpl(int totalUser,TicketBookings bookings[]) {
		this.users = new User[totalUser];
		this.bookings = bookings;
		
		// Default user and amin
		
		users[userCount++] = new User("admin","admin123","admin");
		users[userCount++] = new User("user","user123","user");
		
		
	}
	
	

	@Override
	public boolean registerUser(User user) {
		for(int i = 0 ; i<userCount;i++) {
			if(users[i].getUsername().equals(user.getUsername())) {
				return false;     // user already exits
			}
		}
		
		if(userCount<users.length) {
			users[userCount++] = user;
			return true;
		}
		
		return false;    // user space is full	
	}

	@Override
	public boolean loginUser(User user) {
		for(int i = 0;i<userCount;i++) {
			if(users[i].getUsername().equals(user.getUsername()) &&  users[i].getPassword().equals(user.getPassword())) {
				return true;  // login successful
			}
		}
		return false;
	}

	@Override
	public boolean bookEvent(String username, String eventId, String eventName) {
		boolean userExits = false;
		for(int i = 0;i<userCount;i++) {
			if(users[i].getUsername().equals(username)) {
				userExits = true;
				break;
			}
		}
		
		if(!userExits) return false;
		
		// Book the Event
		
		if(bookingCount < bookings.length) {
			bookings[bookingCount++] = new TicketBookings(username, eventId, eventName);
			return true;
			
		}
		return false;
		
	}

}

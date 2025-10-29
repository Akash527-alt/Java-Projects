package com.events.eventsController;

import java.util.Scanner;

import javax.security.auth.login.FailedLoginException;

import com.events.eventsService.EventsService;
import com.events.eventsService.userServiceImpl;
import com.events.eventsService.userService;
import com.events.pojos.Event;
import com.events.pojos.User;

public class EventsController {
	
	private EventsService eventsService;
	private userService userService;
	private String currentUser = null;
	private String currentRole = null;
	
	
	public EventsController(EventsService eventsService, userService userService) {
		this.eventsService = eventsService;
		this.userService = userService;
	}
	
	public void start()
	{
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("\n---Event Management system---");
			System.out.println("1. Admin login ");
			System.out.println("2. user login ");
			System.out.println("3. Exit ");
			System.out.println("Enter you choice: ");
			
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			
			switch(choice) {
			case 1:
				loginOrRegister(scanner,"Admin");
				break;
			case 2:
				loginOrRegister(scanner, "User");
				break;	
			case 3:
				System.out.println("Exiting system....exited! ");
				scanner.close();
				return;
			default: System.out.println("Invalid choice, please try again!");
			}
			
			
		}
		
		
	}
	
	public void loginOrRegister(Scanner scanner, String role) {
		
		while(true) {
			System.out.println("\n ---"+role+" Menu ---");
			System.out.println(" 1. Register ");
			System.out.println(" 2. Login ");
			System.out.println(" 3. Back ");
			System.out.println("  Enter your choice:  ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			
			switch(choice) {
			case 1: 
				System.out.println("Enter username: ");
				String username = scanner.nextLine();
				System.out.println("Enter password: ");
				String password = scanner.nextLine();
				boolean registered = userService.registerUser(new User(username, password,role));
				if(registered) {
					System.out.println("Registered Successfully. ");
				}
				else {
					System.out.println("User alread	y Exists ");
				}
				break;
				
				
				
			case 2: 
				System.out.println("Enter username: ");
				String loginUser = scanner.nextLine();
				System.out.println("Enter password: ");
				String loginPass = scanner.nextLine();
				boolean login = userService.loginUser(new User(loginUser,loginPass,role));
				if(login) {
					System.out.println("Login successful.");
					currentUser = loginUser;
					currentRole = role;
					
					if(role.equals("Admin")) {
						adminMenu(scanner);
					}
					else {
						userMenu(scanner);
					}
					return;
				}else {
					System.out.println("Login faile, Enter correct Information!");
				}
				break;
				
			case 3:
				
				return;
			default:
				System.out.println("Invalid choice , Try again!");
			}
			
		}
		
		
	}
	
	public void adminMenu(Scanner scanner) {
		while(true) {
			System.out.println("\n---Welcome admin---");
			System.out.println("1. Add event");
			System.out.println("2. View event ");
			System.out.println("3. Delete Event ");
			System.out.println("4. Update Event ");
			System.out.println("5. logout ");
			System.out.println("Enter you choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter event ID: ");
				String id = scanner.nextLine();
				System.out.println("Enter Event Name: ");
				String name = scanner.nextLine();
				System.out.println("Enter Event Date (DD/MM/YYYY): ");
				String date = scanner.nextLine();
				System.out.println("Enter Available Seats: ");
				int seats = scanner.nextInt();
				scanner.nextLine();
				
				if(eventsService.addEvent(new Event(id,name,date,seats))) {
					System.out.println("Event added Successfully");
				}else {
					System.out.println("Failed to add event. Storage is full");
				}
				break;
				
				
				
				
				
			case 2:
				Event[] events = eventsService.getAllEvents();
				if(events.length == 0) {
					System.out.println("No events found");
				}else {
					for (Event event : events) {
						System.out.println(event);
					}
				}
				break;
				
				
			case 3:
				System.out.println("Enter Event ID to Delete: ");
				String eventId= scanner.next();
				if(eventsService.deleteEvent(eventId)) {
					System.out.println("Event deleted successfully !!");
				}else {
					System.out.println("Event with given EventID not found");
				}
				break;
				
			case 4:
				System.out.println("Enter Event Id to update ");
				String newid = scanner.nextLine();
				System.out.println("Enter Event Name: ");
				String newname = scanner.nextLine();
				System.out.println("Enter Event Date (DD/MM/YYYY) : ");
				String newdate = scanner.nextLine();
				System.out.println("Enter available seats : ");
				int newseats = scanner.nextInt();
				
				
				if(eventsService.updateEvent(new Event(newid,newname,newdate,newseats)) != null){
					System.out.println("Event updated successfully !!");
				}else {
					System.out.println("Failed to update event. Event with given id not found");
				}
				break;
				
				
			case 5:
				System.out.println("Logging out from admin menu");
				return;
				
				
			default: System.out.println("Invalid choice, please try again!");
		
	}
}
}
	
	public void userMenu(Scanner scanner) {
		while(true) {
			System.out.println("--- user Menu ---");
			System.out.println("1. View Events");
			System.out.println("2. Register for Event ");
			System.out.println("3. Logout ");
			System.out.println("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			
			switch(choice) {
			case 1:
				Event[] events = eventsService.getAllEvents();
				if(events.length == 0) {
					System.out.println("No Events found !" );	
				}else {
					for (Event event : events) {
						System.out.println(event);
					}
				}
				break;
				
				
			case 2: 
				System.out.println("Enter Event ID to register: ");
				String eventId = scanner.nextLine();
				System.out.println("Enter event Name");
				String eventName = scanner.nextLine();
				boolean booked = userService.bookEvent(currentUser, eventId, eventName);
				if(booked) {
					System.out.println("Event booked Successful");
				}else {
					System.out.println("Booking Failed");
				}
				
				break;
				
			case 3:
				System.out.println("Logging out from user menu...! successfully logout");
				return;
				
				
			default: System.out.println("Invalid choice, try again. ");
			}
			
			
		}
		
	}

}

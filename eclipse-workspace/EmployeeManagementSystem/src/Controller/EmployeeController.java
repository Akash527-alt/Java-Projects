package Controller;

import java.util.List;
import java.util.Scanner;

import Models.Employee;
import Service.EmployeeService;
import Views.EmployeeViews;

public class EmployeeController {
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		
		while(true) 
		{
			EmployeeViews.displayMainMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			case 1:
				adminMene(scanner);
				break;
			case 2:
				userMenu(scanner);
				break;
			case 3:
				System.out.println("System Exiting... GoodBye!");
				scanner.close();
				return;	
			default:
				System.out.println("Invalid Choice, Pleasy Try Again!!");
			}
		}
		
		
	}

//	System.out.println("---Admin Menu---");
//	System.out.println("1. Add Employee");
//	System.out.println("2. View Employees");
//	System.out.println("3. Delete Employee");
//	System.out.println("4. Update  Employee");
//	System.out.println("5. Logout");
//	System.out.println("Enter Your Choice: ");

	private void adminMene(Scanner scanner) {
		while(true){
			EmployeeViews.diaplayAdminMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter employee Id: ");
				int id = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter employee Name: ");
				String name = scanner.nextLine();
				System.out.println("Enter employee Salary: ");
				int salary = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter employee Emergency contact : ");
				String emergencyContact = scanner.nextLine();
				
				Employee addedEmployee = employeeService.addEmployee(new Employee(id,name,salary,emergencyContact));
				System.out.println("Employee Added successfully: "+ addedEmployee);
				break;
			case 2:
				List<Employee> employees = employeeService.getEmployees();
				for(Employee employee:employees) {
					System.out.println(employee);
				}
				break;
			case 3:
				System.out.println("Enter employee Id : ");
				int empyeeId = scanner.nextInt();
				scanner.nextLine();
				System.out.println(employeeService.getEmployeeById(empyeeId));
				break;
			case 4:
				System.out.println("Enter employee Id to delete: ");
				int employeeId = scanner.nextInt(); 
				scanner.nextLine();
				boolean isDeleted =	employeeService.deleteEmployee(employeeId);
				if(isDeleted) System.out.println("Employee Deleted Successfully.");
				break;
			case 5:
				System.out.println("Enter employee id to update: " );
				int empId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter employee New Department: ");
				String newDepartment = scanner.nextLine();
				System.out.println("Enter employee New Salary : ");
				int newSalary = scanner.nextInt();
				scanner.nextLine();
				Employee updateEmployee = employeeService.updateEmployee(empId, newDepartment, newSalary);
				System.out.println(updateEmployee);
				break;
			case 6:
				System.out.println("Enter Department ID: ");
				int departmentId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Employee ID: ");
				int emplId = scanner.nextInt();
				scanner.nextLine();
				Employee employee = employeeService.assignDepartment(emplId, departmentId);
				System.out.println(employee);
				break;
				
			case 7:
				System.out.println("Logging Out From Admin Menu!");
				return;
			default:
				System.out.println("Invalid choice, Try Again! ");
			}
			
		}
		
	}
	
//	System.out.println("---User Menu---");
//	System.out.println("1. View own profile");
//	System.out.println("2. Update Profile");
//	System.out.println("3. Logout ");
//	System.out.println("Enter Your Choice: ");
	private void userMenu(Scanner scanner) {
		EmployeeViews.displayUserMenu();
		System.out.println("--- Employee Menu ---");
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		switch(choice) {
		case 1:
			System.out.println("Enter your Employee Id: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println(employeeService.getEmployeeById(id));
			break;
		case 2:
			System.out.println("Enter Employee Id to Update : ");
			int empId = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter new Emergency Contact: ");
			String newContact = scanner.nextLine();
			System.out.println(employeeService.updateEmployeeEmergencyContact(empId, newContact));
			break;
		case 3:
			System.out.println("Loggin out from user Menu... Logged Out");
			return;
		default:
			System.out.println("Invalid Choice, Try Again!");
		}
		
	}
	
	
	
	
	
}

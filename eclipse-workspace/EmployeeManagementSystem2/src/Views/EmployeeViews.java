
package Views;

public class EmployeeViews {
	
	public static void displayMainMenu() {
		System.out.println("\n--- Employee Management System ---");
		System.out.println("1. Admin Login");
		System.out.println("2. Employee Login");
		System.out.println("3.  Exit");
		System.out.println(" Enter Your Choice: ");
	}
	
	public static void diaplayAdminMenu() {
		System.out.println("\n---Admin Menu---");
		System.out.println("1. Add Employee");
		System.out.println("2. View Employees");
		System.out.println("3. GetEmployee By Id Employees");		
		System.out.println("4. Delete Employee");
		System.out.println("5. Update  Employee");
		System.out.println("6. Assign Department ");		
		System.out.println("7. Logout");
		System.out.println("Enter Your Choice: ");
	}
	
	public static void displayUserMenu() {
		System.out.println("\n---User Menu---");
		System.out.println("1. View own profile");
		System.out.println("2. Update Profile");
		System.out.println("3. Logout ");
		System.out.println("Enter Your Choice: ");
	}

}

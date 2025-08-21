package Repository;

import java.util.List;

import Models.Department;
import Models.Employee;

public interface EmployeeRepository {

	Employee addEmployee(Employee employee);
	Employee getEmployeeById(int id);
	List<Employee> getEmployees();
	//Employee getEmployees();
	Employee updateEmployee(int id, Department newDepartment, int newSalary);
	boolean deleteEmployee(int id);
	Employee updateEmployeeEmergencyContact(int id, String newContact);

	
	
}

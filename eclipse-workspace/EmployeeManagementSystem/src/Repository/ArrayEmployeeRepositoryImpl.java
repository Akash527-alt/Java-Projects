package Repository;

import java.util.Arrays;
import java.util.List;

import Models.Department;
import Models.Employee;

public class ArrayEmployeeRepositoryImpl implements EmployeeRepository{

	private Employee[] employees;
	private int employeeCount;
	
	public ArrayEmployeeRepositoryImpl(int employeeCount) {
		employees = new Employee[employeeCount];
		this.employeeCount = 0;
	}
	
	
	@Override
	public Employee addEmployee(Employee employee) {
		Employee newEmployee = null;
		if(employees.length ==0) {
			employees[employeeCount++] = employee;
			newEmployee = employee;
			
		}
		
		else if( employeeCount > employees.length) {
			return null;
		}
		else {
			employees[employeeCount++] = employee;
			newEmployee = employee;
		}
		return newEmployee;
	}
	

	@Override
	public Employee getEmployeeById(int id) {
		Employee foundEmployee = null;
		for(int i = 0; i < employeeCount ; i++) {
			if(employees[i].getId() == id) {
				foundEmployee = employees[i];
			}
		}
		return  foundEmployee;
	}

	@Override
	public List<Employee> getEmployees() {
		Employee[] coppiedEmployee = Arrays.copyOf(employees, employeeCount);
		return null; 		// returning null for the time being
	}

	@Override
	public Employee updateEmployee(int id, Department newDepartment, int newSalary) {
		// find the employee
		// change what should be changed
		
		Employee existingEmployee = getEmployeeById(id);
		if(existingEmployee != null) {
		//	existingEmployee.setDepartment(newDepartment);
			existingEmployee.setSalary(newSalary);
		}
		
		return  existingEmployee;
		
	}

	@Override
	public boolean deleteEmployee(int id) {
		// Find the employee with given id
		// Delete and shift the array logic
		boolean foundEmployee = false;
		for(int i = 0; i<employeeCount;i++) {   
			if(employees[i].getId() == id) {       // found Employee
				for(int j = i ; j < employeeCount ; j++) {    // Delete Employee
					employees[j] = employees[j+1];
					
				}
				employees[employeeCount--] = null;
				foundEmployee = true;
			}
		}
		return foundEmployee;
	}

	@Override
	public Employee updateEmployeeEmergencyContact(int id, String newContact) {
		// Get the employee with given id
		// update the given detail
		
		Employee employee = getEmployeeById(id);
		if(employee != null) {
			employee.setEmergencyContact(newContact);
		}
		
		return employee ;
	}
	

}

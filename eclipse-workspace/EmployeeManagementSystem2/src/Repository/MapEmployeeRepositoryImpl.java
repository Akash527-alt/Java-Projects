package Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Models.Department;
import Models.Employee;

public class MapEmployeeRepositoryImpl implements EmployeeRepository{
	
	private final Map<Integer, Employee> mapEmployee ;
	
	
	
	

	public MapEmployeeRepositoryImpl() {
		this.mapEmployee = new HashMap<>();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		if(mapEmployee.containsKey(employee.getId())) {
			throw new RuntimeException("duplicate Employee ID is not allowed");
		}
		
		mapEmployee.put(employee.getId(),employee);
		return employee;
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return mapEmployee.get(id);
	}

	@Override
	public List<Employee> getEmployees() {
		return new ArrayList<>(mapEmployee.values());
	}

	@Override
	public Employee updateEmployee(int id, Department newDepartment, int newSalary) {
		// use the key to find the existing employee
		// modify the current employee object
		Employee existingEmployee = mapEmployee.get(id);
		
		if(existingEmployee != null) {
			existingEmployee.setDepartment(newDepartment);
			existingEmployee.setSalary(newSalary);
			
		}
		
		return existingEmployee;
	}

	@Override
	public boolean deleteEmployee(int id) {
		if(mapEmployee.containsKey(id)) {
			mapEmployee.remove(id);
			return true;
		}
		return false;
		
		
	}

	@Override
	public Employee updateEmployeeEmergencyContact(int id, String newContact) {
		Employee employee = mapEmployee.get(id);
		if(employee != null) {
			employee.setEmergencyContact(newContact);
		}
		
		return employee;
	}
	

}

package Service;

import java.util.List;

import Models.Department;
import Models.Employee;
import Repository.DepartmentRepository;
import Repository.EmployeeRepository;
import exceptions.EmployeeLimitReachedException;
import exceptions.EmployeeNotFoundException;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	private DepartmentRepository departmentRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}
	

	@Override
	public Employee addEmployee(Employee employee) {
		Employee createdEmployee = employeeRepository.addEmployee(employee);
		if(createdEmployee == null) {
			throw new EmployeeLimitReachedException("No more Employee Can be Added!");
		}
		return createdEmployee;
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = employeeRepository.getEmployeeById(id);
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee with given id not found" + id);
		}
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.getEmployees();
	}

	@Override
	public Employee updateEmployee(int id, String newDepartment, int newSalary) {
		Department department = departmentRepository.getDepartmentByName(newDepartment);
		Employee employee = employeeRepository.updateEmployee(id, department, newSalary);
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee Id not found: "+ id);
		}
		return employee;
	}

	@Override
	public boolean deleteEmployee(int id) {
		boolean isEmployeeDeleted = employeeRepository.deleteEmployee(id);
		if(isEmployeeDeleted == false) {
		}
		return isEmployeeDeleted;
	}

	@Override
	public Employee updateEmployeeEmergencyContact(int id, String newContact) {
		Employee employee = employeeRepository.updateEmployeeEmergencyContact(id, newContact);
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee id not found: "+id);
		}
		return employee;
	}


	@Override
	public Employee assignDepartment(int empId, int deptId) {
		// find the employee and department with the given id
		Employee employee = getEmployeeById(empId);
		Department department = departmentRepository.getDepartmentById(deptId);
		employee.setDepartment(department);
		return employee;
	}
	

}

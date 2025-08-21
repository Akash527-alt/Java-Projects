package Views;

import Repository.EmployeeRepository;
import Repository.MapDepartmentRepositoryImpl;
import Repository.MapEmployeeRepositoryImpl;
import Service.EmployeeService;
import Service.EmployeeServiceImpl;
import Controller.EmployeeController;
import Models.Department;
import Repository.ArrayEmployeeRepositoryImpl;
import Repository.ArrayDepartmentRepositoryImpl;
import Repository.DepartmentRepository;



public class Main {
	public static void main(String[] args) {
		DepartmentRepository departmentRepository = new MapDepartmentRepositoryImpl();
		EmployeeRepository employeeRepository = new MapEmployeeRepositoryImpl();
		EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository,departmentRepository);
		EmployeeController employeeController = new EmployeeController(employeeService);
		employeeController.start();
		
	}

}

package Repository;

import java.util.List;

import Models.Department;

public interface DepartmentRepository {
	Department addDepartment(Department department);
	Department updateDepartment(Department department);
	List<Department> getAllDepartment();
	boolean DeleteDepartment(int id);
	Department getDepartmentById(int id);
	Department getDepartmentByName(String  name);
	
	
	

}
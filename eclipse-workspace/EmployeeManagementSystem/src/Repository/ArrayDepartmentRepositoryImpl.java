package Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Models.Department;

public class ArrayDepartmentRepositoryImpl implements DepartmentRepository{
	Department[] departments;
	int departmentCount;
	
	public ArrayDepartmentRepositoryImpl(int departmentCount) {
		this.departments = new Department[departmentCount];
		departments[0] = new Department(1,"HR","Blr","200");
		departments[1] = new Department(2,"FINANCE","Blr","200");
		departments[2] = new Department(3,"ENGINEERING","BLR","200");
		this.departmentCount=3;
	}
 
	@Override
	public Department addDepartment(Department department) {
		return null;
	}

	@Override
	public Department updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> getAllDepartment() {
		return new ArrayList<>(Arrays.asList(departments));
	}

	@Override
	public boolean DeleteDepartment(int id) 
	{
		return false;
	}

	@Override
	public Department getDepartmentById(int id) {
		Department foundDepartment = null;
		for(int i = 0;i<departmentCount;i++) {
			if(departments[i].getId() == id) {
				foundDepartment = departments[i];
				System.out.println(foundDepartment);
			}
		}
		return foundDepartment;
	}

	@Override
	public Department getDepartmentByName(String name) {
		Department department = null;
		for(int i=0;i<departmentCount;i++) {
			if(departments[i].getName().equalsIgnoreCase(name)) {
				department = departments[i];
			}
		}
		return department;
	}

}

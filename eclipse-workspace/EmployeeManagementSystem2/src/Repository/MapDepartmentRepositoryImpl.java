package Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Models.Department;

public class MapDepartmentRepositoryImpl implements DepartmentRepository {
	private final Map<Integer,Department> departmentMap;
	
	
	
	public MapDepartmentRepositoryImpl() {

		this.departmentMap = new HashMap<>();
		this.departmentMap.put(1, new Department(1,"HR","GR","100"));
		this.departmentMap.put(2, new Department(1,"Developers","Top floor","100"));
		this.departmentMap.put(3, new Department(1,"Accounting","GR","100"));
		
		
		
	}
	

	@Override
	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> getAllDepartment() {
		return new ArrayList<>(departmentMap.values());
	}

	@Override
	public boolean DeleteDepartment(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Department getDepartmentById(int id) {
		return departmentMap.get(id);
	}

	@Override
	public Department getDepartmentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

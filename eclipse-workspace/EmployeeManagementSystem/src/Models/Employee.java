package Models;

public class Employee {
	private int id;
	private String name;
	private Department department;
	private String dob;
	private int salary;
	private String emergencyContact;
	
	public Employee(int id, String name, int salary, String emergencyContact) {
		super();
		this.id = id;
		this.name = name;
		
		this.salary = salary;
		this.emergencyContact = emergencyContact;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Department getDepartment() {
		return department;
	}

	public int getSalary() {
		return salary;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", dob=" + dob + ", salary="
				+ salary + ", emergencyContact=" + emergencyContact + "]";
	}
	
	
	

}

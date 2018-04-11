/*
* Name: Parth Purohit
* Block: C
* Date: April 6, 2018
* Teacher: Mr. Harris
*/	

public abstract class Employee {

	private String employeeId = "";
	private String employeeName = "";
	private String employeeType = "";
	
	public abstract double paycheck(); 
	public abstract void raise(double raise);
	
	
	

	public Employee(String id, String name, String type) {
		this.employeeId = id;
		this.employeeName = name;
		this.employeeType = type;
	}
	
	public void changeName(String newName) {
		this.employeeName = newName;
	}
	
	public String getName() {
		return this.employeeName;
	}
	
	public String getID() {
		return this.employeeId;
	}
	
	public String getType() {
		return this.employeeType;
	}
		
	@Override
	public String toString() {
		return "Employee Type: " + this.employeeType + ", Employee Id: " + this.employeeId + ", Employee Name: " + this.employeeName;
	}


}

/*
* Name: Parth Purohit
* Block: C
* Date: April 6, 2018
* Teacher: Mr. Harris
*/	

public class SalariedEmployee extends Employee{

	private double annualSalary = 0;
	
	public SalariedEmployee(String id, String name, String empType) {
		super(name, id, empType);
	}

	public void setSalary(double salary) {
		this.annualSalary = salary;
	}
	
	@Override
	public void raise(double raise) {
		this.annualSalary += raise;
	}
	
	@Override
	public double paycheck() {
		return (annualSalary / 52);
	}
	
	@Override
	public String toString() {
		return "Employee Type: " + getType() + ", Employee Name: " + getName()
		+ ", Employee Id: " + getID() +", Employee Annual Salary: " + this.annualSalary
		+ ", Weekly Employee Pay: " + paycheck();
	}
	
}
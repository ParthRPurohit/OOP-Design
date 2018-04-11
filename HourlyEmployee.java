/*
* Name: Parth Purohit
* Block: C
* Date: April 6, 2018
* Teacher: Mr. Harris
*/	

public class HourlyEmployee extends Employee{

	
	private double hours = 0;
	private double pay = 0;

	
	
	public HourlyEmployee(String name, String id, String empType) {
		super(id, name, empType);
	}

	public void setHours(double work) {
		this.hours = work;
	}
	
	public void setHourlyPay(double payy) {
		this.pay = payy;
	}
	
	public double getPay() {
		return this.pay;
	}
	
	@Override
	public void raise(double raise) {
		this.pay += raise;
	}

	@Override
	public double paycheck() {
		if(hours < 41) {
			return hours * getPay();
		} else {
			return 40 * getPay() + (hours-40) * 1.5 * getPay();
		}
	}
	
	@Override
	public String toString() {
		return "Employee Type: " + getType() + ", Employee Name: " + getName() 
		+ ", Employee Id: " + getID() + ", Employee Hours: " + hours + ", Hourly Pay: "
		+ getPay() + ", Pay check: " + paycheck();
	}

}

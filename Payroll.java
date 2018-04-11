

import java.io.*;
import java.util.*;

/*
* Name: Parth Purohit
* Block: C
* Date: April 6, 2018
* Teacher: Mr. Harris
*/	

public class Payroll {

	private static List<Employee> payroll = new LinkedList<Employee>();

	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		int choice = 0;
		System.out.println("Hello! This is the payroll system!\n");	
		
		while(choice != 6) {
			System.out.println();			
			System.out.println("1. Print Payroll");
			System.out.println("2. Add Employee");
			System.out.println("3. Remove Employee");
			System.out.println("4. Total Payroll");
			System.out.println("5. Employee Record");
			System.out.println("6. Quit");
			System.out.println();
			
			choice = cin.nextInt();
			
			if(choice == 1) {
				Display();
			} else if(choice == 2) {
				
				Scanner empType = new Scanner(System.in);
				System.out.println("What kind of employee would you like to add(hourly/salaried): ");
				String employeeTyp = empType.nextLine();
				addEmp(employeeTyp);
				
			} else if(choice == 3) {
				
				remEmployee();
			} else if(choice == 4) {
			 	
				UserTotalPay();
			} else if(choice == 5) {
				
				System.out.println("Enter employee Id: ");
				Scanner id = new Scanner(System.in);
				String id1 = id.nextLine();
				EmpRec(id1);
			}
		}
		System.out.println("Bye!");
		System.exit(0);
	}

	public static void addEmp(String empType) {
		
		boolean sameId = false;
		empType.toLowerCase();
		Scanner cin = new Scanner(System.in);
		if (empType.equals("hourly")) {
			
			System.out.println("Name of employee: ");
			String name = cin.nextLine();
			System.out.println("Employee ID: ");
			String id = cin.nextLine();
			
			for(Employee e : payroll) {
				if(e.getID().equals(id)) {
					System.out.println("Error: Employee Id already exists");
					sameId = true;
				}
			}
			
			if(!sameId) {
				System.out.println("Current Pay: ");
				double currPay = cin.nextDouble();
				HourlyEmployee employee = new HourlyEmployee(name, id, "hourly");
				System.out.println("How many hours has employee \"" + name + "\" worked? ");
				double hoursWorked = cin.nextDouble();
				employee.setHours(hoursWorked);
				employee.setHourlyPay(currPay);
				payroll.add(employee);
			}
			
		} else if(empType.equals("salaried")) {
			
			System.out.println("Name of employee: ");
			String name = cin.nextLine();
			System.out.println("Employee ID: ");
			String id = cin.nextLine();
			
			for(Employee e : payroll) {
				if(e.getID().equals(id)) {
					System.out.println("Error: Employee Id already exists");
					sameId = true;
				}
			}
			
			if(!sameId) {
				SalariedEmployee emp2 = new SalariedEmployee(name, id, "salaried");
				System.out.println("Current Annual Salary: ");
				double currentSalary = cin.nextDouble();
				emp2.setSalary(currentSalary);
				payroll.add(emp2);
			}
		} else {
			System.out.println("Incorect Employee Type");
		}
	}

	public static void remEmployee(){
		Scanner cin = new Scanner(System.in);
		System.out.println("Employee Id: ");
		String id = cin.nextLine();
		for(int a = 0; a < payroll.size(); a++) {
			Employee currEmp = payroll.get(a);
			if(currEmp.getID().equals(id)) {
				payroll.remove(currEmp);
			}
		}
	}

	public static void updateHours(String id) {
		Scanner cin = new Scanner(System.in);
		
		System.out.println("How many hours has the employee worked?");
		double work = cin.nextDouble();
		
		for(Employee e : payroll) {
			if(e.getID().equals(id)) {
				HourlyEmployee employee = (HourlyEmployee) e;
				int employeeIndex = payroll.indexOf(e);
				employee.setHours(work);
				payroll.set(employeeIndex, employee);
			}
		}
	}

	public static void Display() {
		ArrayList<Employee> hourlySort = new ArrayList<Employee>();
		ArrayList<Employee> salariedSort = new ArrayList<Employee>();
		
		for(Employee e : payroll) {
			if(e.getType().equals("hourly")) {
				hourlySort.add(e);
			}else if(e.getType().equals("salaried")) {
				salariedSort.add(e);
			}
			Collections.sort(hourlySort, new PayrollComparator());
			Collections.sort(salariedSort, new PayrollComparator());
		}
		payroll.clear();
		payroll.addAll(hourlySort);
		payroll.addAll(salariedSort);
		if(payroll.size() > 0) {
			for(Employee e : payroll) {
				System.out.println(e.toString());
			}
		}else {
			System.out.println("No employees present");
		}
	}

	public static void UserTotalPay() {
		double total = 0;
		for(Employee e : payroll) {
			total += e.paycheck();
		}
		System.out.println("Total Weekly pay for the company is: $" + total);
	}

	public static void EmpRec(String id){
		int choice = 0;
		boolean found = false;
		Employee currEmp = null;
		Employee currEmp2 = null;
		Scanner cin = new Scanner(System.in);
		for(Employee e : payroll) {
			if(e.getID().equals(id)) {
				currEmp = e;
				found = true;
				break;
			}else {
				found = false;
			}
		}
		if(found == false) {
			System.out.println("No employee with that ID exists.");
		}
		while(choice != 4 && found) {
			for(Employee e : payroll) {
				if(e.getID().equals(id)) {
					currEmp2 = e;
					break;
				}
			}
			
			System.out.println("Current Employee: " + currEmp2.toString());
			System.out.println("1. Give raise");
			System.out.println("2. Update Name");
			System.out.println("3. Update Hours");
			System.out.println("4. Exit Submenu");
			
			choice = cin.nextInt();
			if (choice == 1) {
				System.out.println("What is the amount to be added to the employee's pay: ");
				Scanner raisePay = new Scanner(System.in);
				double raise = raisePay.nextDouble();
				currEmp.raise(raise);
			} else if(choice == 2) {
				System.out.println("What is the employee's new name: ");
				Scanner name = new Scanner(System.in);
				String newName = name.nextLine();
				currEmp.changeName(newName);
			} else if(choice == 3) {
				if(currEmp.getType().equals("salaried")) {
					System.out.println("Error: Cannot change hours for a salaried employee");
				} else {
					updateHours(id);
				}
			} else if(choice != 4) {
				System.out.println("Invalid Menu Option");
			}
		}
	}
}
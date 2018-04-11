/*
* Name: Parth Purohit
* Block: C
* Date: April 6, 2018
* Teacher: Mr. Harris
*/	

import java.util.*;

public class PayrollComparator implements Comparator<Employee>{
	public int compare(Employee o1, Employee o2) {
			return o1.getName().compareTo(o2.getName());
	}
}
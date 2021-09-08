package com.bridgelabz.employeepayrollservice;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayrollService {

	public static void main(String[] args) {
		EmployeePayrollService emp=new EmployeePayrollService();
		ArrayList<EmployeePayrollData> employee=new ArrayList<>();
		Scanner input=new Scanner(System.in);
		emp.readEmployeeDetail(input,employee);
		emp.writeEmployeeDetails(employee);
	}
		public void readEmployeeDetail(Scanner input,ArrayList<EmployeePayrollData> employee) {
		System.out.println("Enter Employee Id");
		int id=input.nextInt();
		System.out.println("Enter Employee Name");
		String name=input.next();
		System.out.println("Enter Employee salary");
		double salary=input.nextDouble();
		employee.add(new EmployeePayrollData(id,name,salary));
	
	}
		private void writeEmployeeDetails(ArrayList<EmployeePayrollData> employee) {
			
			System.out.println(employee);
		}

}

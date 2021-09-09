package com.bridgelabz.employeepayrollservice;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayrollService {

	public List<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService() {
	
	}

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	public static void main(String[] args) {

		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService emp = new EmployeePayrollService(employeePayrollList);
		Scanner input = new Scanner(System.in);
		emp.readEmployeeDetail(input, employeePayrollList);
		emp.writeEmployeePayrollData(com.bridgelabz.employeepayrollservice.IOService.CONSOLE_IO);
	}

	public void readEmployeeDetail(Scanner input, ArrayList<EmployeePayrollData> employee) {
		System.out.println("Enter Employee Id");
		int id = input.nextInt();
		System.out.println("Enter Employee Name");
		String name = input.next();
		System.out.println("Enter Employee salary");
		double salary = input.nextDouble();
		employee.add(new EmployeePayrollData(id, name, salary));

	}

	public void writeEmployeePayrollData(com.bridgelabz.employeepayrollservice.IOService IOService) {
		if (IOService.equals(com.bridgelabz.employeepayrollservice.IOService.CONSOLE_IO)) {
			System.out.println(employeePayrollList);
		} else if (IOService.equals(com.bridgelabz.employeepayrollservice.IOService.FILE_IO)) {

			new EmployeePayrollFileIOService().writeData(employeePayrollList);
		}
	}

	public void printData(IOService IOService) {
		if (IOService.equals(IOService.FILE_IO))
			new EmployeePayrollFileIOService().printData();
	}

	public long countEntries(IOService IOService) {
		if (IOService.equals(IOService.FILE_IO))

			return new EmployeePayrollFileIOService().countEntries();
		return 0;

	}

	public long readEmployeePayrollData(IOService IOService) {
		if(IOService.equals(IOService.FILE_IO))
			this.employeePayrollList=new EmployeePayrollFileIOService().readData();
		return employeePayrollList.size();
	}

}

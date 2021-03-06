package com.bridelabz.employeepayrollservicetest;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.employeepayrollservice.EmployeePayrollData;
import com.bridgelabz.employeepayrollservice.EmployeePayrollService;
import com.bridgelabz.employeepayrollservice.IOService;
public class EmployeePayrollServiceTest {
@Test
	public void givenEmployeeWhenWrittenToFileShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmps= {
				new EmployeePayrollData(1,"jeff Bezos",100000),
				new EmployeePayrollData(2,"Bill Gates",200000),
				new EmployeePayrollData(3,"Mark Zuckerberge",300000)
		};
		EmployeePayrollService employeePayrollService;
		employeePayrollService=new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
    	employeePayrollService.printData(IOService.FILE_IO);
		long entries=employeePayrollService.countEntries(IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	
	}
}

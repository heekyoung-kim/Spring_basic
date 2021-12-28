        
package com.sample.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.service.EmployeeService;
import com.sample.vo.Employee;

public class EmployeeSelectAllApplication {

	public static void main(String[] args) {
		String resource = "classpath:/spring/context-jdbc.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		EmployeeService service = ctx.getBean(EmployeeService.class);
		
		List<Employee> employeeList = service.getAllEmployees();
		for (Employee emp : employeeList) {
			System.out.println(emp.getId() + ", " + emp.getFirstName() + ", " + emp.getJobId());
		}
		
	}
}

    
        
package com.sample.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.service.EmployeeService;
import com.sample.vo.Employee;

public class EmployeeInsertApplication {

	public static void main(String[] args) {
		String resource = "classpath:/spring/context-jdbc.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		EmployeeService service = ctx.getBean(EmployeeService.class);
		
		Employee employee = new Employee();
		employee.setFirstName("홍");
		employee.setLastName("길동");
		employee.setPhoneNumber("010-1234-5678");
		employee.setEmail("honghong@gmail.com");
		
		service.addNewEmployee(employee);
		
		
	}
}

    
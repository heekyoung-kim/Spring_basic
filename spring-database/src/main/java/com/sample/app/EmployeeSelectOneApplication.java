        
package com.sample.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.service.EmployeeService;
import com.sample.vo.Employee;

public class EmployeeSelectOneApplication {

	public static void main(String[] args) {
		
		String resource = "classpath:/spring/context-jdbc.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		EmployeeService service = ctx.getBean(EmployeeService.class);
		
		Employee employee = service.getEmployeeDetail(100);
		System.out.println("아이디: " + employee.getId());
		System.out.println("이름: " + employee.getFirstName());
		System.out.println("전화번호: " + employee.getPhoneNumber());
		System.out.println("직종아이디: " + employee.getJobId());
		System.out.println("입사일: " + employee.getHireDate());
		System.out.println("급여: " + employee.getSalary());
	}
}

    
package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.service.EmployeeService;
import com.sample.vo.Employee;

/*
 * http://localhost/emp/list.do 요청을 처리한느 요청 핸들러 메소드다.
 * 요청핸들러 메소드가 반환하는 값은 내부이동 혹은 재요청할 URL이다.
 * 
 * 요청처리를 완료하면 /WEB-INF/jsp/employee/list.jsp로 내부이동시킨다.
 */
// @Controller는 Http요청을 처리할 수 있는 컨트롤러라는 의미.
@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(path="/list.do")
	public String list(Model model) {
		// 전체 직원목록 조회
		List<Employee> employees = employeeService.getAllEmployees();
		// employee/list.jsp에서 표현할 데이터를 Model객체에 저장한다.
		model.addAttribute("employees", employees);
		
		return "/employee/list.jsp";
	}
}

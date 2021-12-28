        
package com.sample.service;

import java.util.List;

import com.sample.dao.EmployeeDao;
import com.sample.vo.Employee;

/**
 * 직원정보 관리에 필요한 서비스 메소드가 구현된 클래스다.
 * @author lee_e
 *
 */
public class EmployeeServiceImpl implements EmployeeService {
	
	/**
	 * EmployeeDao는 직원관리에 필요한 데이터베이스 엑세스를 지원하는 인터페이스다.
	 * 스프링 컨테이너에 빈으로 등록된 EmployeeDao 인터페이스의 구현객체를 의존성 주입을 사용해서 제공받는다.
	 * 		+ EmployeeDao 타입의 멤버변수 선언
	 * 		+ EmployeeDao 구현객체를 전달받는 setter 메소드 정의
	 */
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public void addNewEmployee(Employee employee) {
		employeeDao.insert(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeDetail(int employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}
}

    
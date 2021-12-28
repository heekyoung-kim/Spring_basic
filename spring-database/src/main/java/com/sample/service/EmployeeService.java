        
package com.sample.service;

import java.util.List;

import com.sample.vo.Employee;

/**
 * 직원정보 관리에 필요한 서비스 메소드가 정의된 인터페이스다.
 * @author lee_e
 *
 */
public interface EmployeeService {

	/**
	 * 새 직원정보 등록서비스를 제공한다.
	 * @param employee 새 직원정보를 포함하고 있는 Employee객체
	 */
	void addNewEmployee(Employee employee);
	
	/**
	 * 모든 직원 정보를 반환하는 서비스를 제공한다.
	 * @return 모든 직원정보
	 */
	List<Employee> getAllEmployees();
	
	/**
	 * 지정된 직원아이디에 해당하는 직원의 상세정보를 반환하는 서비스를 제공한다.
	 * @param employeeId 직원아이디
	 * @return 직원정보
	 */
	Employee getEmployeeDetail(int employeeId);
	
}

    
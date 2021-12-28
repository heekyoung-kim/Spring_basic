        
package com.sample.dao;

import java.util.List;

import com.sample.vo.Employee;

/**
 * 사원정보 관리에 필요한 데이터베이스 엑세스 작업을 정의한 인터페이스
 * @author lee_e
 *
 */
public interface EmployeeDao {

	void insert(Employee employee);
	void delete(int employeeId);
	void update(Employee employee);
	Employee getEmployeeById(int employeeId);
	List<Employee> getAllEmployees();
}

    
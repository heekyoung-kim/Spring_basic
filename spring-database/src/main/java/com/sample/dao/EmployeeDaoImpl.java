        
package com.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sample.vo.Employee;

/**
 * 사원정보 관리에 필요한 데이터베이스 엑세스 작업이 구현된 클래스다.
 * @author lee_e
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {
	
	/**
	 * JdbcTemplate는 INSERT, UPDATE, DELETE, SELECT 쿼리실행 기능을 제공하는 클래스다.
	 * 스프링 컨테이너의 빈으로 등록하고, 데이터베이스 엑세스 작업을 담당하는 xxxDaoImpl은 의존성 주입을 사용해서 제공받는다.
	 * 		+ JdbcTemplate 타입의 멤버변수 선언
	 * 		+ JdbcTemplate 객체를 전달받는 setter 메소드 정의
	 */
	private JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void insert(Employee employee) {
		String sql = "insert into employees "
				+ "(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id) "
				+ "values "
				+ "(employees_seq.nextval, ?, ?, ?, ?, sysdate, 'ST_CLERK', 2008, 120, 50)";
		
		template.update(sql, 
				employee.getFirstName(), 
				employee.getLastName(), 
				employee.getEmail(), 
				employee.getPhoneNumber());
	}

	@Override
	public void delete(int employeeId) {
		String sql = "delete from employees where employee_id = ?";
		
		template.update(sql, employeeId);
	}

	@Override
	public void update(Employee employee) {
		String sql = "update employees "
				+ "set "
				+ "		job_id = ?, "
				+ "		salary = ?, "
				+ "		commission_pct = ?, "
				+ "		manager_id = ?, "
				+ "		department_id = ? "
				+ "where employee_id = ? ";
		
		template.update(sql, 
				employee.getJobId(), 
				employee.getSalary(), 
				employee.getCommissionPct() > 0 ? employee.getCommissionPct() : null, 
				employee.getManagerId(), 
				employee.getDepartmentId(), 
				employee.getId());		
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		String sql = "select * from employees where employee_id = ?";
		return template.queryForObject(sql, new EmployeeRowMapper(), employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		String sql = "select * from employees";
		return template.query(sql, new EmployeeRowMapper());
	}
	
	public class EmployeeRowMapper implements RowMapper<Employee> {
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setEmail(rs.getString("email"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
			
			return emp;
		}
	}

	
}

    
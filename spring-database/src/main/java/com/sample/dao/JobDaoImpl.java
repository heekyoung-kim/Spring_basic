package com.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sample.vo.Job;

public class JobDaoImpl implements JobDao {

	private JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void insertJob(Job job) {
		String sql = "insert into jobs(job_id, job_titile, min_salary, max_salary) valuese(?, ?, ?, ?) ";
		template.update(sql, 
				job.getId(),
				job.getTitle(),
				job.getMinSalary(),
				job.getMaxSalary());
	}

	@Override
	public void updateJob(Job job) {
		String sql = "update jobs "
				+"set "
				+ "		min_salary = ?, "
				+ "		max_salary = ? "
				+ "where job_id = ? ";
		template.update(sql, job.getMinSalary(),job.getMaxSalary(), job.getId());
	}

	@Override
	public List<Job> getAllJobs() {
		String sql = "select * from jobs ";
		return template.query(sql, new RowMapper<Job>(){
			@Override
			public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
				Job job = new Job();
				job.setId(rs.getString("job_id"));
				job.setTitle(rs.getString("job_title"));
				job.setMinSalary(rs.getInt("min_salary"));
				job.setMaxSalary(rs.getInt("max_salary"));
				
				return job;
			}
		});
	}

	// 람다식으로 rowMapper 표현
	// 수행문이 2줄 이상일 경우 {}안에 넣어서 표현해야함.
	@Override
	public Job getJobById(String id) {
		String sql = "select * from jobs where job_id = ? ";
		return template.queryForObject(sql, (rs, rownum) -> {
			Job job = new Job();
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			job.setMinSalary(rs.getInt("min_salary"));
			job.setMaxSalary(rs.getInt("max_salary"));
			return job;
		}, id);
	}

	@Override
	public List<Job> getJobsBySalary(int minSalary, int maxSalary) {
		String sql =  "select * from jobs where min_salary <= ? and max_salary >= ?";
		return template.query(sql, (rs, rownum) -> {
			Job job = new Job();
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			job.setMinSalary(rs.getInt("min_salary"));
			job.setMaxSalary(rs.getInt("max_salary"));		
			
			return job;
		}, minSalary, maxSalary);
	}

}

package com.sample.dao;

import java.util.List;

import com.sample.vo.Job;

public interface JobDao {
	
	void insertJob(Job job);
	void updateJob(Job job);
	List<Job> getAllJobs();
	Job getJobById(String id);
	List<Job> getJobsBySalary(int minSalary, int maxSalary);
}

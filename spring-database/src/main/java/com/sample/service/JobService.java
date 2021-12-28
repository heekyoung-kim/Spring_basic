package com.sample.service;

import java.util.List;

import com.sample.vo.Job;

public interface JobService {
	
	void insertNewJob(Job job);
	List<Job> getAllJobs();
	List<Job> getJobsBySalary(int minSalary, int maxSalary);
	Job getJobDetail(String jobId);
}

package com.sample.service;

import java.util.List;

import com.sample.dao.JobDao;
import com.sample.vo.Job;

public class JobServiceImpl implements JobService {

	private JobDao jobDao;
	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}
	
	// dao에 정의되어있는 db엑세스 작업들을 업무로직에서 활용하는 것. service에서 조건이나 업무로직을 구현.
	@Override
	public void insertNewJob(Job job) {
		Job savedJob = jobDao.getJobById(job.getId());
		if (savedJob != null) {
			throw new RuntimeException("동일한 직종아이디가 이미 등록되어 있습니다.");
		}
		if (job.getMaxSalary() <= job.getMinSalary()) {
			throw new RuntimeException("최대 급여는 최소 급여보다 작거나 같을 수 없습니다.");
		}
		jobDao.insertJob(job);
	}

	@Override
	public List<Job> getAllJobs() {
		return jobDao.getAllJobs();
	}

	@Override
	public List<Job> getJobsBySalary(int minSalary, int maxSalary) {
		return jobDao.getJobsBySalary(minSalary, maxSalary);
	}

	@Override
	public Job getJobDetail(String jobId) {
		return jobDao.getJobById(jobId);
	}

}

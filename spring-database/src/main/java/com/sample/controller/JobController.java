package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sample.service.JobService;

@Controller
public class JobController {
	
	@Autowired
	private JobService jobService;
}

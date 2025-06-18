package com.zhaopin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaopin.model.entity.JobSeeker;

public interface JobSeekerService {
    JobSeeker addJobSeeker(JobSeeker jobSeeker);
    JobSeeker updateJobSeeker(JobSeeker jobSeeker);
    void deleteJobSeeker(Long id);
    JobSeeker getJobSeekerById(Long id);
    Page<JobSeeker> getJobSeekerList(Integer pageNum, Integer pageSize);
} 
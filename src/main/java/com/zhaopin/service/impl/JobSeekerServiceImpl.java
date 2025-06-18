package com.zhaopin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaopin.mapper.JobSeekerMapper;
import com.zhaopin.model.entity.JobSeeker;
import com.zhaopin.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {

    @Autowired
    private JobSeekerMapper jobSeekerMapper;

    @Override
    public JobSeeker addJobSeeker(JobSeeker jobSeeker) {
        jobSeekerMapper.insert(jobSeeker);
        return jobSeeker;
    }

    @Override
    public JobSeeker updateJobSeeker(JobSeeker jobSeeker) {
        jobSeekerMapper.updateById(jobSeeker);
        return jobSeeker;
    }

    @Override
    public void deleteJobSeeker(Long id) {
        jobSeekerMapper.deleteById(id);
    }

    @Override
    public JobSeeker getJobSeekerById(Long id) {
        return jobSeekerMapper.selectById(id);
    }

    @Override
    public Page<JobSeeker> getJobSeekerList(Integer pageNum, Integer pageSize) {
        Page<JobSeeker> page = new Page<>(pageNum, pageSize);
        return jobSeekerMapper.selectPage(page, null);
    }
} 
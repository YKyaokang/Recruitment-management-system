package com.zhaopin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaopin.mapper.JobPostMapper;
import com.zhaopin.model.entity.JobPost;
import com.zhaopin.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPostServiceImpl implements JobPostService {

    @Autowired
    private JobPostMapper jobPostMapper;

    @Override
    public JobPost addJobPost(JobPost jobPost) {
        jobPostMapper.insert(jobPost);
        return jobPost;
    }

    @Override
    public JobPost updateJobPost(JobPost jobPost) {
        jobPostMapper.updateById(jobPost);
        return jobPost;
    }

    @Override
    public void deleteJobPost(Long id) {
        jobPostMapper.deleteById(id);
    }

    @Override
    public JobPost getJobPostById(Long id) {
        return jobPostMapper.selectById(id);
    }

    @Override
    public Page<JobPost> getJobPostList(Integer pageNum, Integer pageSize) {
        Page<JobPost> page = new Page<>(pageNum, pageSize);
        return jobPostMapper.selectPage(page, null);
    }

    @Override
    public Page<JobPost> getJobPostListByCompany(Long companyId, Integer pageNum, Integer pageSize) {
        Page<JobPost> page = new Page<>(pageNum, pageSize);
        QueryWrapper<JobPost> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("company_id", companyId);
        return jobPostMapper.selectPage(page, queryWrapper);
    }
} 
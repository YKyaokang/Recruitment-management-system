package com.zhaopin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaopin.model.entity.JobPost;

public interface JobPostService {
    JobPost addJobPost(JobPost jobPost);
    JobPost updateJobPost(JobPost jobPost);
    void deleteJobPost(Long id);
    JobPost getJobPostById(Long id);
    Page<JobPost> getJobPostList(Integer pageNum, Integer pageSize);
    Page<JobPost> getJobPostListByCompany(Long companyId, Integer pageNum, Integer pageSize);
} 
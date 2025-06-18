package com.zhaopin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaopin.model.common.Result;
import com.zhaopin.model.entity.JobPost;
import com.zhaopin.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job-post")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    @PostMapping
    public Result<JobPost> addJobPost(@RequestBody JobPost jobPost) {
        return Result.success(jobPostService.addJobPost(jobPost));
    }

    @PutMapping
    public Result<JobPost> updateJobPost(@RequestBody JobPost jobPost) {
        return Result.success(jobPostService.updateJobPost(jobPost));
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteJobPost(@PathVariable Long id) {
        jobPostService.deleteJobPost(id);
        return Result.success(null);
    }

    @GetMapping("/{id}")
    public Result<JobPost> getJobPostById(@PathVariable Long id) {
        JobPost jobPost = jobPostService.getJobPostById(id);
        if (jobPost != null) {
            return Result.success(jobPost);
        }
        return Result.error("招聘信息不存在");
    }

    @GetMapping("/list")
    public Result<Page<JobPost>> getJobPostList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(jobPostService.getJobPostList(pageNum, pageSize));
    }

    @GetMapping("/company/{companyId}")
    public Result<Page<JobPost>> getJobPostListByCompany(
            @PathVariable Long companyId,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(jobPostService.getJobPostListByCompany(companyId, pageNum, pageSize));
    }
} 
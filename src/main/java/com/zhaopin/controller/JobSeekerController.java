package com.zhaopin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaopin.model.common.Result;
import com.zhaopin.model.entity.JobSeeker;
import com.zhaopin.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job-seeker")
public class JobSeekerController {

    @Autowired
    private JobSeekerService jobSeekerService;

    @PostMapping
    public Result<JobSeeker> addJobSeeker(@RequestBody JobSeeker jobSeeker) {
        return Result.success(jobSeekerService.addJobSeeker(jobSeeker));
    }

    @PutMapping
    public Result<JobSeeker> updateJobSeeker(@RequestBody JobSeeker jobSeeker) {
        return Result.success(jobSeekerService.updateJobSeeker(jobSeeker));
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteJobSeeker(@PathVariable Long id) {
        jobSeekerService.deleteJobSeeker(id);
        return Result.success(null);
    }

    @GetMapping("/{id}")
    public Result<JobSeeker> getJobSeekerById(@PathVariable Long id) {
        JobSeeker jobSeeker = jobSeekerService.getJobSeekerById(id);
        if (jobSeeker != null) {
            return Result.success(jobSeeker);
        }
        return Result.error("求职者不存在");
    }

    @GetMapping("/list")
    public Result<Page<JobSeeker>> getJobSeekerList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(jobSeekerService.getJobSeekerList(pageNum, pageSize));
    }
} 
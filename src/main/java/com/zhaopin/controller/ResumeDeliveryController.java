package com.zhaopin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaopin.model.common.Result;
import com.zhaopin.model.entity.ResumeDelivery;
import com.zhaopin.service.ResumeDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume-delivery")
public class ResumeDeliveryController {

    @Autowired
    private ResumeDeliveryService resumeDeliveryService;

    @PostMapping
    public Result<ResumeDelivery> addResumeDelivery(@RequestBody ResumeDelivery resumeDelivery) {
        return Result.success(resumeDeliveryService.addResumeDelivery(resumeDelivery));
    }

    @PutMapping
    public Result<ResumeDelivery> updateResumeDelivery(@RequestBody ResumeDelivery resumeDelivery) {
        return Result.success(resumeDeliveryService.updateResumeDelivery(resumeDelivery));
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteResumeDelivery(@PathVariable Long id) {
        resumeDeliveryService.deleteResumeDelivery(id);
        return Result.success(null);
    }

    @GetMapping("/{id}")
    public Result<ResumeDelivery> getResumeDeliveryById(@PathVariable Long id) {
        ResumeDelivery resumeDelivery = resumeDeliveryService.getResumeDeliveryById(id);
        if (resumeDelivery != null) {
            return Result.success(resumeDelivery);
        }
        return Result.error("简历投递记录不存在");
    }

    @GetMapping("/list")
    public Result<Page<ResumeDelivery>> getResumeDeliveryList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(resumeDeliveryService.getResumeDeliveryList(pageNum, pageSize));
    }

    @GetMapping("/job-seeker/{jobSeekerId}")
    public Result<Page<ResumeDelivery>> getResumeDeliveryListByJobSeeker(
            @PathVariable Long jobSeekerId,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(resumeDeliveryService.getResumeDeliveryListByJobSeeker(jobSeekerId, pageNum, pageSize));
    }

    @GetMapping("/job-post/{jobPostId}")
    public Result<Page<ResumeDelivery>> getResumeDeliveryListByJobPost(
            @PathVariable Long jobPostId,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(resumeDeliveryService.getResumeDeliveryListByJobPost(jobPostId, pageNum, pageSize));
    }
} 
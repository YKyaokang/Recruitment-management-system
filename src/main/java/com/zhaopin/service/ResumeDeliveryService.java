package com.zhaopin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaopin.model.entity.ResumeDelivery;

public interface ResumeDeliveryService {
    ResumeDelivery addResumeDelivery(ResumeDelivery resumeDelivery);
    ResumeDelivery updateResumeDelivery(ResumeDelivery resumeDelivery);
    void deleteResumeDelivery(Long id);
    ResumeDelivery getResumeDeliveryById(Long id);
    Page<ResumeDelivery> getResumeDeliveryList(Integer pageNum, Integer pageSize);
    Page<ResumeDelivery> getResumeDeliveryListByJobSeeker(Long jobSeekerId, Integer pageNum, Integer pageSize);
    Page<ResumeDelivery> getResumeDeliveryListByJobPost(Long jobPostId, Integer pageNum, Integer pageSize);
} 
 
package com.zhaopin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaopin.mapper.ResumeDeliveryMapper;
import com.zhaopin.model.entity.ResumeDelivery;
import com.zhaopin.service.ResumeDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeDeliveryServiceImpl implements ResumeDeliveryService {

    @Autowired
    private ResumeDeliveryMapper resumeDeliveryMapper;

    @Override
    public ResumeDelivery addResumeDelivery(ResumeDelivery resumeDelivery) {
        resumeDeliveryMapper.insert(resumeDelivery);
        return resumeDelivery;
    }

    @Override
    public ResumeDelivery updateResumeDelivery(ResumeDelivery resumeDelivery) {
        resumeDeliveryMapper.updateById(resumeDelivery);
        return resumeDelivery;
    }

    @Override
    public void deleteResumeDelivery(Long id) {
        resumeDeliveryMapper.deleteById(id);
    }

    @Override
    public ResumeDelivery getResumeDeliveryById(Long id) {
        return resumeDeliveryMapper.selectById(id);
    }

    @Override
    public Page<ResumeDelivery> getResumeDeliveryList(Integer pageNum, Integer pageSize) {
        Page<ResumeDelivery> page = new Page<>(pageNum, pageSize);
        return resumeDeliveryMapper.selectPage(page, null);
    }

    @Override
    public Page<ResumeDelivery> getResumeDeliveryListByJobSeeker(Long jobSeekerId, Integer pageNum, Integer pageSize) {
        Page<ResumeDelivery> page = new Page<>(pageNum, pageSize);
        QueryWrapper<ResumeDelivery> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("job_seeker_id", jobSeekerId);
        return resumeDeliveryMapper.selectPage(page, queryWrapper);
    }

    @Override
    public Page<ResumeDelivery> getResumeDeliveryListByJobPost(Long jobPostId, Integer pageNum, Integer pageSize) {
        Page<ResumeDelivery> page = new Page<>(pageNum, pageSize);
        QueryWrapper<ResumeDelivery> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("job_post_id", jobPostId);
        return resumeDeliveryMapper.selectPage(page, queryWrapper);
    }
} 
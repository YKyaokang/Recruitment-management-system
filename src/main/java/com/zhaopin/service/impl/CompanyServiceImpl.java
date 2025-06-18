package com.zhaopin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaopin.mapper.CompanyMapper;
import com.zhaopin.model.entity.Company;
import com.zhaopin.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Company addCompany(Company company) {
        companyMapper.insert(company);
        return company;
    }

    @Override
    public Company updateCompany(Company company) {
        companyMapper.updateById(company);
        return company;
    }

    @Override
    public void deleteCompany(Long id) {
        companyMapper.deleteById(id);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyMapper.selectById(id);
    }

    @Override
    public Page<Company> getCompanyList(Integer pageNum, Integer pageSize) {
        Page<Company> page = new Page<>(pageNum, pageSize);
        return companyMapper.selectPage(page, null);
    }
} 
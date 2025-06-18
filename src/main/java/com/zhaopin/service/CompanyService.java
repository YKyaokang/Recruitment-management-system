package com.zhaopin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaopin.model.entity.Company;

public interface CompanyService {
    Company addCompany(Company company);
    Company updateCompany(Company company);
    void deleteCompany(Long id);
    Company getCompanyById(Long id);
    Page<Company> getCompanyList(Integer pageNum, Integer pageSize);
} 
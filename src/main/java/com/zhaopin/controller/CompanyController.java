package com.zhaopin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaopin.model.common.Result;
import com.zhaopin.model.entity.Company;
import com.zhaopin.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Result<Company> addCompany(@RequestBody Company company) {
        return Result.success(companyService.addCompany(company));
    }

    @PutMapping
    public Result<Company> updateCompany(@RequestBody Company company) {
        return Result.success(companyService.updateCompany(company));
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return Result.success(null);
    }

    @GetMapping("/{id}")
    public Result<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        if (company != null) {
            return Result.success(company);
        }
        return Result.error("企业不存在");
    }

    @GetMapping("/list")
    public Result<Page<Company>> getCompanyList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(companyService.getCompanyList(pageNum, pageSize));
    }
} 
package com.kazakova.spring.service;

import com.kazakova.spring.database.repository.CompanyRepository;
import com.kazakova.spring.database.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private CompanyService companyService;

    public UserService(UserRepository userRepository,
                       CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }
}

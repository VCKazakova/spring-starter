package com.kazakova.spring.service;

import com.kazakova.spring.database.entity.Company;
import com.kazakova.spring.database.repository.CrudRepository;
import com.kazakova.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;
}

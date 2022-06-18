package com.kazakova.spring.database.repository;

import com.kazakova.spring.bpp.InjectBean;
import com.kazakova.spring.database.pool.ConnectionPool;

public class CompanyRepository {

    @InjectBean
    private final ConnectionPool connectionPool;



}

package com.kazakova.spring.database.repository;

import com.kazakova.spring.bpp.Auditing;
import com.kazakova.spring.bpp.InjectBean;
import com.kazakova.spring.bpp.Transaction;
import com.kazakova.spring.database.entity.Company;
import com.kazakova.spring.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {

    @InjectBean
    private final ConnectionPool connectionPool;

    @PostConstruct
    public void init() {
        System.out.println("Init company repo");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("Find by id method");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("Delete method");
    }
}

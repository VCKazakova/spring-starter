package com.kazakova.spring.database.repository;

import com.kazakova.spring.bpp.Auditing;
import com.kazakova.spring.bpp.Transaction;
import com.kazakova.spring.database.entity.Company;
import com.kazakova.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Transaction
@Auditing
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CompanyRepository implements CrudRepository<Integer, Company> {

    private final ConnectionPool pool1;
    private final List<ConnectionPool> pools;
    private final Integer poolSize;

    public CompanyRepository(ConnectionPool pool1,
                             List<ConnectionPool> pools,
                             @Value("${db.pool.size}") Integer poolSize) {
        this.pool1 = pool1;
        this.pools = pools;
        this.poolSize = poolSize;
    }


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

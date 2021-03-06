package com.kazakova.spring.service;

import com.kazakova.spring.database.entity.Company;
import com.kazakova.spring.database.repository.CrudRepository;
import com.kazakova.spring.dto.CompanyReadDto;
import com.kazakova.spring.listener.entity.AccessType;
import com.kazakova.spring.listener.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CrudRepository<Integer, Company> crudRepository;
    private final UserService userService;
    private final ApplicationEventPublisher publisher;

    public CompanyService(CrudRepository<Integer, Company> crudRepository,
                          UserService userService,
                          ApplicationEventPublisher publisher) {
        this.crudRepository = crudRepository;
        this.userService = userService;
        this.publisher = publisher;
    }

    public Optional<CompanyReadDto> findById(Integer id) {
        return crudRepository.findById(id)
                .map(entity -> {
                    publisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.id());
                });
    }

}

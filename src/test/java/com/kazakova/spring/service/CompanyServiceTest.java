package com.kazakova.spring.service;

import com.kazakova.spring.database.entity.Company;
import com.kazakova.spring.database.repository.CrudRepository;
import com.kazakova.spring.dto.CompanyReadDto;
import com.kazakova.spring.listener.entity.EntityEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {

    private static final Integer COMPANY_ID = 1;

    @Mock
    private CrudRepository<Integer, Company> crudRepository;
    @Mock
    private UserService userService;
    @Mock
    private ApplicationEventPublisher publisher;
    @InjectMocks
    private CompanyService companyService;

    @Test
    void findById() {
        doReturn(Optional.of(new Company(COMPANY_ID))).when(crudRepository).findById(COMPANY_ID);

        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);

        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
//  проверка, что поведение отработало только раз
        verify(publisher).publishEvent(any(EntityEvent.class));
        // проверка на то, что дополнитлельное взаимодействие с моками не осуществлялось
        verifyNoMoreInteractions(publisher, userService);
    }

}
package com.kazakova.spring.integration.service;

import com.kazakova.spring.database.pool.ConnectionPool;
import com.kazakova.spring.integration.annotation.IT;
import com.kazakova.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@IT
@RequiredArgsConstructor
//контекст не будет переиспользоваться, для каждого теста будет использован новый
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceIT {

    private final UserService userService;
    private final ConnectionPool pool1;

    @Test
//    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    void test() {

    }
}

package com.kazakova.spring.database.entity;

import java.io.Serializable;
// помогает при ручном создании репо, сервисов, т.к. можно аппелировать одной моделью
public interface BaseEntity<T extends Serializable> {

    T getId();

    void setId(T id);
}

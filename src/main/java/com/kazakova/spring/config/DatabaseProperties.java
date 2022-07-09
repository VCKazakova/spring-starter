package com.kazakova.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "db")
public record DatabaseProperties( // дублируем поля из проперти файла
                                  String username,
                                  String password,
                                  String driver,
                                  String url,
                                  String hosts,
                                  // сущность с полями как в проперти
                                  PoolProperties pool,
                                  // лист как в проперти
                                  List<PoolProperties> pools,
                                  // мап как в проперти
                                  Map<String, Object> properties) {


    // сущность с полями как в проперти
    public static record PoolProperties(Integer size,
                                        Integer timeout) {

    }

}

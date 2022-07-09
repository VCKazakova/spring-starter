package com.kazakova.spring.integration.database.repository;

import com.kazakova.spring.database.entity.Company;
import com.kazakova.spring.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@IT
// ставим, чтобы избежать lazyinisializationexception
//@Transactional
//@Rollback // чистит контекст после транзакции, по дефолту
//@Commit // коммитит изменения
@RequiredArgsConstructor
class CompanyRepositoryTest {

    private final EntityManager entityManager;
    // ручное управление транзакциями
    private final TransactionTemplate transactionTemplate;

    @Test
    void findById() {
        // падает, если исключение не Runtime или error
        transactionTemplate.executeWithoutResult(
                tx -> {
                    var company = entityManager.find(Company.class, 1);
                    assertNotNull(company);
                    assertThat(company.getLocales()).hasSize(2);
                }
        );
    }

    @Test
    void save() {
        var company = Company.builder()
                .name("Apple")
                .locales(Map.of("ru", "Apple описание",
                        "en", "Apple description"))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }
}
package io.spring.base.repository;

import io.spring.base.domain.Authority;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AuthorityRepositoryTest {

    @Autowired
    private AuthorityRepository authorityRepository;


    @BeforeEach
    void setUp() {
        System.out.println("--- BeforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("--- AfterEach");
    }

    @Test
    void findAll(){

        List<Authority> list = authorityRepository.findAll();

        assertThat(list).isNotEmpty();

    }
}
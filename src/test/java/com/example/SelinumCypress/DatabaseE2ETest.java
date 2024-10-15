package com.example.SelinumCypress;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest
public class DatabaseE2ETest {

    @Autowired
    private UserRepository userRepository;

    static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:12.3")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpassword");

    @BeforeAll
    public static void setUp() {
        postgresContainer.start();
        System.setProperty("DB_URL", postgresContainer.getJdbcUrl());
        System.setProperty("DB_USERNAME", postgresContainer.getUsername());
        System.setProperty("DB_PASSWORD", postgresContainer.getPassword());
    }

    @Test
    public void testDatabaseInteraction() {
        User user = new User("testuser", "password");
        userRepository.save(user);

        User fetchedUser = userRepository.findByUsername("testuser");
        assertEquals("testuser", fetchedUser.getUsername());
    }
}

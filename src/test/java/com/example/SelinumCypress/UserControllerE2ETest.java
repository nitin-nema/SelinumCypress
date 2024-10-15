package com.example.SelinumCypress;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerE2ETest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testUserCreation() {
        // Send a POST request to create a user
        UserDto user = new UserDto("testuser", "password");
        ResponseEntity<UserDto> response = restTemplate.postForEntity("/users", user, UserDto.class);

        // Assert that the response is correct --POST
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody().getUsername()).isEqualTo("testuser");

        // Test fetching the created user-- GET
        ResponseEntity<UserDto> getUserResponse = restTemplate.getForEntity("/users/testuser", UserDto.class);
        assertThat(getUserResponse.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(getUserResponse.getBody().getUsername()).isEqualTo("testuser");
    }
}


// asserEquals(actual result, expected result)
// asserThat(actual).isEqualTo(expected)
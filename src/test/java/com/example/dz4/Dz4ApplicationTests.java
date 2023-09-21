package com.example.dz4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Dz4ApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRest() {
        Input input = new Input();
        input.setAnimalType("Пес");
        input.setAge(55);
        input.setCountry("Россия");

        HttpEntity<Input> request = new HttpEntity<>(input);

        ResponseEntity<Output> response = restTemplate.exchange("/rest", HttpMethod.POST, request, Output.class);

        assertEquals(200, response.getStatusCodeValue());

        Output output = response.getBody();

        assert output != null;
        assertEquals("ЭТО ЗАГЛУШКА", output.getMessage());
        assertEquals("Тип животного: Пес", output.getData());
        assertEquals("Год рождения животного: 1968", output.getDataY());
        assertEquals("Страна обитания: Россия", output.getDataC());
    }
}

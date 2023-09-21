package com.example.dz4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Dz4Application {
        @RequestMapping(value = "/rest", method = {RequestMethod.POST, RequestMethod.PUT})
        public Output rest(@RequestBody Input input) {
            Output output = new Output();
            output.setMessage("ЭТО ЗАГЛУШКА");
            output.setData("Тип животного: " + input.getAnimalType());
            output.setDataY("Год рождения животного: " + (2023 - input.getAge()));
            output.setDataC("Страна обитания: " + input.getCountry());
            return output;
        }
    public static void main(String[] args) {
        SpringApplication.run(Dz4Application.class, args);
    }
}

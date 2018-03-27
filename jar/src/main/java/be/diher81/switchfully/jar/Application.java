package be.diher81.switchfully.jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "be.diher81.switchfully")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

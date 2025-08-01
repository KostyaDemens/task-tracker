package by.bsuir.kostyademens.tasktrackerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TaskTrackerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskTrackerBackendApplication.class, args);

        //TODO Expired JWT Expiration + Signature exception - надо подумать как красиво обработать
    }

}

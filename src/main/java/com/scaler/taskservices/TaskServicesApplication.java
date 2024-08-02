package com.scaler.taskservices;

import com.scaler.taskservices.models.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskServicesApplication.class, args);

        Task task = new Task();
        task.setTitle("iPhone 15");
    }

}

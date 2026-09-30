package com.homestay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point of the Homestay Host Management Platform backend.
 *
 * Feature modules (auth, user, property, room, guest, booking, dashboard)
 * are added as sub-packages of com.homestay during Sprints 1-3.
 */
@SpringBootApplication
public class HomestayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomestayApplication.class, args);
    }
}

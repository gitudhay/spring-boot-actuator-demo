package com.uk.actuator.spring_boot_actuator_demo.controller;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    /**
     * Greeting endpoint.
     *
     * @return string.
     * @throws InterruptedException if interrupted.
     */
    @GetMapping("/greeting")
    @Timed(value = "request.greeting", extraTags = {"env", "local"})
    public String greeting() throws InterruptedException {
        // Sleep between 0 and 5 seconds
        Thread.sleep((long) (Math.random() * 5000));
        return "Hi from Spring Boot Actuator Demo";
    }
}

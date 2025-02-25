package com.Greet.Greeting.App.GreetController;

import com.Greet.Greeting.App.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @GetMapping
    public String greeting() {
        return "{\"message\":\"Hello World!\"}";
    }

    @PostMapping
    public String greetingPost() {
        return "{\"message\":\"Greeting Received\"}";
    }

    @PutMapping
    public String greetingPut() {
        return "{\"message\":\"Greeting Updated\"}";
    }

    @DeleteMapping
    public String greetingDelete() {
        return "{\"message\":\"Greeting Deleted\"}";
    }

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/service")
    public String greetingService() {
        return greetingService.greeting();
    }
}

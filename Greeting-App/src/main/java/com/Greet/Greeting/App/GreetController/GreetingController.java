package com.Greet.Greeting.App.GreetController;

import com.Greet.Greeting.App.Model.Greeting;
import com.Greet.Greeting.App.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private GreetingService GreetingService;

    @GetMapping
    public String getGreeting(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        return "{\"message\": \"" + greetingService.getGreetingMessage(firstName, lastName)+"\"}";
    }

    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody String message) {
        return greetingService.saveGreeting(message);
    }

    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PutMapping("/edit/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody String newMessage) {
        return greetingService.updateGreeting(id, newMessage);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
    }




}

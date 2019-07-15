package reservation_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/restaurants")
public class RestaurantController {

    @GetMapping
    public String hello(){
        return "Hello";
    }
}

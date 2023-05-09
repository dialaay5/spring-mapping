package spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping(value = "/hello")
    public String getHello() {
        return "<h1 style=\"color:blue\">HELLO WORLD!</h1>";
    }


}

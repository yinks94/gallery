package kr.ink94.gallery.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class MainController {

    @GetMapping("/api/greeting")
    public String greet(){
        return "Hello SpringBoot & Vue3";
    }
}

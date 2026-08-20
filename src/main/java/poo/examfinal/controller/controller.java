package poo.examfinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
        @GetMapping("/ping")
        public String ping() {
            return "pong";
        }
}

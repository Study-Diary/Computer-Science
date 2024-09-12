package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/filter")
    public void testFilter() {
        log.info("Controller with filter !!!!!");
    }

    @GetMapping("/interceptor")
    public void testInterceptor() {
        log.info("Controller with interceptor !!!!!");
    }
}

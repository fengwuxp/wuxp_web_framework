package com.wuxp.shop.web;


import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


@RestController
@RequestMapping(path = "/test", produces = {APPLICATION_JSON_UTF8_VALUE})
public class TestRestController {


    @GetMapping("/test")
    Flux<String> test() {
        return Flux.just("124");
    }

}

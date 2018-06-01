package com.webservices.endpoints;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController
{
    @RequestMapping(value="/hello-world", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("{test:Hello World}");
    }
}

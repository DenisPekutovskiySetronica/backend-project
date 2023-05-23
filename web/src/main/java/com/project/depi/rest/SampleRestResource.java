package com.project.depi.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("${url.mapping_prefix}")
@ApiIgnore
public class SampleRestResource {

    @RequestMapping(value = "/hello",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloWorld(@RequestParam("name") String name) {
        return String.format("Hello %s", name);
    }

}

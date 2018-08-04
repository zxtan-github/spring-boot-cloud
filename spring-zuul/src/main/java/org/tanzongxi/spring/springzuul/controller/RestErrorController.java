package org.tanzongxi.spring.springzuul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/error")
public class RestErrorController extends AbstractErrorController {

    @Autowired
    public RestErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @Override
    public String getErrorPath() {
        return "/errorXX";
    }

    @RequestMapping(produces = MediaType.ALL_VALUE)
    public String errorXX(HttpServletRequest request) {
        return "{flg = false}";
    }
}

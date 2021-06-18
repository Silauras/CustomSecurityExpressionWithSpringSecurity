package com.example.customsecurityexpression.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Silauras
 * Created on 18.06.2021 at 14:16
 */

@Controller
public class MainController {

    @PostAuthorize("hasPermission(returnObject, 'read')")
    @GetMapping("/foos/{id}")
    @ResponseBody
    public String findById(@PathVariable long id) {
        return "Sample";
    }

    @PreAuthorize("hasPermission(#foo, 'write')")
    @PostMapping("/foos")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String create(@RequestBody String foo) {
        return foo;
    }
}

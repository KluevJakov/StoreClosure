package com.github.KluevJakov.StoreClosure.controller;

import com.github.KluevJakov.StoreClosure.repository.ClosureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClosureController {
    @Autowired
    private ClosureRepository closureRepository;

    @PostMapping(value = "/createClosure")
    public void createClosure() {

    }

    @GetMapping(value = "/getClosuresForStore")
    public void getClosuresForStore() {

    }

}

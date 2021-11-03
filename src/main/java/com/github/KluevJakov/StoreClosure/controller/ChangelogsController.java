package com.github.KluevJakov.StoreClosure.controller;

import com.github.KluevJakov.StoreClosure.repository.ChangelogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangelogsController {
    @Autowired
    private ChangelogRepository changelogRepository;

    @GetMapping(value = "/getChangelogs")
    public void getChangelogs() {

    }

    @GetMapping(value = "/getChangelogsForStore")
    public void getChangelogsForStore() {

    }

}

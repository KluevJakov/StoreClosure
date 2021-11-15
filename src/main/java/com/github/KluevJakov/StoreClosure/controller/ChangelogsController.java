package com.github.KluevJakov.StoreClosure.controller;

import com.github.KluevJakov.StoreClosure.entity.Changelog;
import com.github.KluevJakov.StoreClosure.service.ChangelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChangelogsController {
    @Autowired
    private ChangelogService changelogService;

    @GetMapping(value = "/getChangelogs")
    public List<Changelog> getChangelogs() {
        return changelogService.findAll();
    }

    @GetMapping(value = "/getChangelogsForStore")
    public List<Changelog> getChangelogsForStore(@RequestParam Long id) {
        return changelogService.findAllByStoreId(id);
    }

}

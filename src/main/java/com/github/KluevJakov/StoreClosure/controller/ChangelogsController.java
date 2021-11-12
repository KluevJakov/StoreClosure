package com.github.KluevJakov.StoreClosure.controller;

import com.github.KluevJakov.StoreClosure.entity.Changelog;
import com.github.KluevJakov.StoreClosure.repository.ChangelogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ChangelogsController {
    @Autowired
    private ChangelogRepository changelogRepository;

    @GetMapping(value = "/getChangelogs")
    public List<Changelog> getChangelogs() {
        return changelogRepository.findAll();
    }

    @GetMapping(value = "/getChangelogsForStore")
    public List<Changelog> getChangelogsForStore(@RequestParam Long id) {
        return changelogRepository.findAll()
                .stream()
                .filter(e -> e.getStoreId().equals(id))
                .collect(Collectors.toList());
    }

}

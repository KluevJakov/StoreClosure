package com.github.KluevJakov.StoreClosure.service;

import com.github.KluevJakov.StoreClosure.entity.Changelog;
import com.github.KluevJakov.StoreClosure.entity.Closure;
import com.github.KluevJakov.StoreClosure.repository.ChangelogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChangelogService {
    @Autowired
    private ChangelogRepository changelogRepository;

    public List<Changelog> findAll() {
        return changelogRepository.findAll();
    }

    public List<Changelog> findAllByStoreId(Long storeId) {
        return changelogRepository.findAll()
                .stream()
                .filter(changelog -> changelog.getStoreId().equals(storeId))
                .collect(Collectors.toList());
    }
}

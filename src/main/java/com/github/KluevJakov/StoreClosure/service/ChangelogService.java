package com.github.KluevJakov.StoreClosure.service;

import com.github.KluevJakov.StoreClosure.entity.Changelog;
import com.github.KluevJakov.StoreClosure.repository.ChangelogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ChangelogService {
    @Autowired
    private ChangelogRepository changelogRepository;

    public List<Changelog> findAll() {
        log.info("Changelog: finding all Changelogs");
        return changelogRepository.findAll();
    }

    public List<Changelog> findAllByStoreId(Long storeId) {
        log.info("Changelog: finding all Changelogs by storeId = " + storeId);
        return changelogRepository.findAllByStoreId(storeId);
    }
}

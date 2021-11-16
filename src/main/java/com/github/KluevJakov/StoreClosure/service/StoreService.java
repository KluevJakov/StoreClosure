package com.github.KluevJakov.StoreClosure.service;

import com.github.KluevJakov.StoreClosure.entity.Changelog;
import com.github.KluevJakov.StoreClosure.entity.Store;
import com.github.KluevJakov.StoreClosure.repository.ChangelogRepository;
import com.github.KluevJakov.StoreClosure.repository.ClosureRepository;
import com.github.KluevJakov.StoreClosure.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ClosureRepository closureRepository;
    @Autowired
    private ChangelogRepository changelogRepository;

    public boolean openStore(Long storeId) {
        if (closureRepository.existsByStoreId(storeId)) {
            closureRepository.deleteAllByStoreId(storeId);
            log.info("Store: all Closures were deleted for storeId = " + storeId);
            Changelog changelog = new Changelog();
            changelog.setChangeDate(new Date());
            changelog.setStoreId(storeId);
            changelog.setReason(Changelog.closureTypeEnum.OPEN);
            //changelog.setChangedBy("");
            changelogRepository.save(changelog);
            log.info("Store: store (id = " + storeId + ") open successfully. Changelog was recorded");
            return true;
        }
        log.warn("Store: attempt to open store (id = " + storeId + ") failed. Store wasn't closed");
        return false;
    }

    public List<Store> findAll() {
        log.info("Store: try to find all Stores");
        return storeRepository.findAll();
    }

    public Optional<Store> findById(Long id) {
        log.info("Store: try to find Store by id = " + id);
        return storeRepository.findById(id);
    }
}
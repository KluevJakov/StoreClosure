package com.github.KluevJakov.StoreClosure.service;

import com.github.KluevJakov.StoreClosure.entity.Store;
import com.github.KluevJakov.StoreClosure.repository.ChangelogRepository;
import com.github.KluevJakov.StoreClosure.repository.ClosureRepository;
import com.github.KluevJakov.StoreClosure.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        }
        return true;
    }

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public Optional<Store> findById(Long id) {
        return storeRepository.findById(id);
    }
}

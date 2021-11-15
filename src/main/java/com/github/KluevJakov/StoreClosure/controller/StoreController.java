package com.github.KluevJakov.StoreClosure.controller;

import com.github.KluevJakov.StoreClosure.entity.Store;
import com.github.KluevJakov.StoreClosure.repository.ClosureRepository;
import com.github.KluevJakov.StoreClosure.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ClosureRepository closureRepository;

    @GetMapping(value = "/getStores")
    public List<Store> getStores() {
        return storeRepository.findAll();
    }

    @GetMapping(value = "/getStoreById")
    public Store getStoreById(@RequestParam Long id) {
        if (storeRepository.findById(id).isPresent()) {
            return storeRepository.findById(id).get();
        }
        throw new NullPointerException();
    }

    @PostMapping(value = "/openStore")
    public void openStore(@RequestParam(value = "storeId") Long storeId) {
        closureRepository.deleteAllByStoreId(storeId);
    }
}

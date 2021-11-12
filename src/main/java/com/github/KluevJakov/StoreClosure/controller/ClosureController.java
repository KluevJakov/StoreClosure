package com.github.KluevJakov.StoreClosure.controller;

import com.github.KluevJakov.StoreClosure.entity.Closure;
import com.github.KluevJakov.StoreClosure.repository.ClosureRepository;
import com.github.KluevJakov.StoreClosure.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClosureController {
    @Autowired
    private ClosureRepository closureRepository;
    @Autowired
    private StoreRepository storeRepository;

    @PostMapping(value = "/createClosure")
    public void createClosure(@RequestParam(value = "storeId") Long storeId, @RequestParam(value = "text") String text, @RequestParam(value = "startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate, @RequestParam(value = "endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate, @RequestParam(value = "closureType") String closureType) {
        Closure closure = new Closure();
        if (storeRepository.existsById(storeId) && startDate.before(endDate)) {
            closure.setStoreId(storeId);
            closure.setStartDate(startDate);
            closure.setEndDate(endDate);
            closure.setClosureType(Closure.closureTypeEnum.valueOf(closureType));
            if (Closure.closureTypeEnum.valueOf(closureType) == Closure.closureTypeEnum.CUSTOM) {
                closure.setText(text);
            }
            closureRepository.save(closure);
        }
    }

    @GetMapping(value = "/getClosuresForStore")
    public List<Closure> getClosuresForStore(@RequestParam Long id) {
        return closureRepository.findAll()
                .stream()
                .filter(e -> e.getStoreId().equals(id))
                .collect(Collectors.toList());
    }

}

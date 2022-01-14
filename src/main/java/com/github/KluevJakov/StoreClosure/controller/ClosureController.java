package com.github.KluevJakov.StoreClosure.controller;

import com.github.KluevJakov.StoreClosure.entity.Closure;
import com.github.KluevJakov.StoreClosure.service.ClosureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
public class ClosureController {
    @Autowired
    private ClosureService closureService;

    @PostMapping(value = "/createClosure")
    public void createClosure(@RequestParam(value = "storeId") Long storeId, @RequestParam(value = "text") String text, @RequestParam(value = "startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") ZonedDateTime startDate, @RequestParam(value = "endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") ZonedDateTime endDate, @RequestParam(value = "closureType") String closureType) {
        if (closureService.createClosure(storeId, text, startDate, endDate, closureType)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    @GetMapping(value = "/getClosuresForStore")
    public List<Closure> getClosuresForStore(@RequestParam Long id) {
        return closureService.findAllByStoreId(id);
    }

}

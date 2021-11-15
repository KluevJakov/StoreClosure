package com.github.KluevJakov.StoreClosure.service;

import com.github.KluevJakov.StoreClosure.entity.Changelog;
import com.github.KluevJakov.StoreClosure.entity.Closure;
import com.github.KluevJakov.StoreClosure.repository.ChangelogRepository;
import com.github.KluevJakov.StoreClosure.repository.ClosureRepository;
import com.github.KluevJakov.StoreClosure.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClosureService {
    @Autowired
    private ClosureRepository closureRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ChangelogRepository changelogRepository;

    public boolean createClosureIfPossible(Long storeId, String text, Date startDate, Date endDate, String closureType) {
        if (storeRepository.existsById(storeId) && startDate.before(endDate)) {
            Closure closure = new Closure();
            closure.setStoreId(storeId);
            closure.setStartDate(startDate);
            closure.setEndDate(endDate);
            closure.setClosureType(Closure.closureTypeEnum.valueOf(closureType));
            if (Closure.closureTypeEnum.valueOf(closureType) == Closure.closureTypeEnum.CUSTOM) {
                closure.setText(text);
            }
            closureRepository.save(closure);

            Changelog changelog = new Changelog();
            changelog.setChangeDate(new Date());
            changelog.setStoreId(storeId);
            changelog.setReason(Changelog.closureTypeEnum.valueOf(closureType));
            //changelog.setChangedBy("");
            changelogRepository.save(changelog);
            return true;
        }
        return false;
    }

    public List<Closure> findAllByStoreId(Long storeId) {
        return closureRepository.findAll()
                .stream()
                .filter(closure -> closure.getStoreId().equals(storeId))
                .collect(Collectors.toList());
    }
}

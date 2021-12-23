package com.github.KluevJakov.StoreClosure.service;

import com.github.KluevJakov.StoreClosure.entity.Changelog;
import com.github.KluevJakov.StoreClosure.entity.Closure;
import com.github.KluevJakov.StoreClosure.repository.ChangelogRepository;
import com.github.KluevJakov.StoreClosure.repository.ClosureRepository;
import com.github.KluevJakov.StoreClosure.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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
            for (Closure closure : closureRepository.findAll()) {
                if (closure.getStoreId().equals(storeId)) {
                    if ((!startDate.after(closure.getEndDate())) || (!endDate.before(closure.getStartDate()))) {
                        log.warn("Closure: date intersection for (storeId = " + storeId + ")");
                        return false;
                    }
                }
            }

            Closure closure = new Closure(storeId, startDate, endDate, Closure.closureTypeEnum.valueOf(closureType));
            if (Closure.closureTypeEnum.valueOf(closureType) == Closure.closureTypeEnum.CUSTOM) {
                closure.setText(text);
            }
            log.info("Closure: " + storeId + " " + startDate + " " + endDate + " " + Closure.closureTypeEnum.valueOf(closureType));

            closureRepository.save(closure);
            log.info("Closure: closure (storeId = " + storeId + ") created successfully");

            Changelog changelog = new Changelog(storeId, new Date(), "stub", Changelog.closureTypeEnum.valueOf(closureType));
            changelogRepository.save(changelog);
            log.info("Closure: changelog (storeId = " + storeId + ") recorded successfully");
            return true;
        }
        log.warn("Closure: store (storeId = " + storeId + ") doesn't exist or startDate > endDate");
        return false;
    }

    public List<Closure> findAllByStoreId(Long storeId) {
        log.info("Closure: finding all Changelogs by storeId = " + storeId);
        return closureRepository.findAllByStoreId(storeId);
    }
}

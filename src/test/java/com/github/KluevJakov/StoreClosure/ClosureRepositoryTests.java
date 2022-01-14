package com.github.KluevJakov.StoreClosure;


import com.github.KluevJakov.StoreClosure.entity.Closure;
import com.github.KluevJakov.StoreClosure.repository.ClosureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Transactional
@SpringBootTest
public class ClosureRepositoryTests {

    @Autowired
    private ClosureRepository closureRepository;
    private Closure closure;

    @BeforeEach
    void setUp() {
        ZonedDateTime zoneDateTime1 = ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneId.of("Europe/Paris"));
        ZonedDateTime zoneDateTime2 = ZonedDateTime.of(2020, 5, 1, 0, 0, 0, 0, ZoneId.of("Europe/Paris"));

        closure = new Closure();
        closure.setText("Test text");
        closure.setStartDate(zoneDateTime1);
        closure.setEndDate(zoneDateTime2);
        closure.setStoreId(1L);
        closure.setClosureType(Closure.closureTypeEnum.CUSTOM);
    }

    @Test
    public void findById() {
        closure = closureRepository.save(closure);
        assertThat(closureRepository.findById(closure.getId())).hasValue(closure);
    }

    @Test
    public void existsByStoreId() {
        closure = closureRepository.save(closure);
        assertTrue(closureRepository.existsByStoreId(closure.getStoreId()));
    }

    @Test
    public void deleteAllByStoreId() {
        closure = closureRepository.save(closure);
        closureRepository.deleteAllByStoreId(closure.getStoreId());
        assertFalse(closureRepository.existsByStoreId(closure.getStoreId()));
    }

}

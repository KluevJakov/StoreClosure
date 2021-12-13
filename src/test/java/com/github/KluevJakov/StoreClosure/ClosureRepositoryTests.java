package com.github.KluevJakov.StoreClosure;


import com.github.KluevJakov.StoreClosure.entity.Closure;
import com.github.KluevJakov.StoreClosure.repository.ClosureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
        closure = new Closure();
        closure.setText("Test text");
        closure.setStartDate(new Date(2020, 1, 1));
        closure.setEndDate(new Date(2020, 5, 1));
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

package com.github.KluevJakov.StoreClosure.repository;

import com.github.KluevJakov.StoreClosure.entity.Changelog;
import com.github.KluevJakov.StoreClosure.entity.Closure;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ClosureRepository extends JpaRepository<Closure, Long> {
    @Transactional
    void deleteAllByStoreId(Long storeId);
    boolean existsByStoreId(Long storeId);
    List<Closure> findAllByStoreId(Long id);
}

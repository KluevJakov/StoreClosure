package com.github.KluevJakov.StoreClosure.repository;

import com.github.KluevJakov.StoreClosure.entity.Closure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ClosureRepository extends JpaRepository<Closure, Long> {
    @Transactional
    void deleteAllByStoreId(Long storeId);
}

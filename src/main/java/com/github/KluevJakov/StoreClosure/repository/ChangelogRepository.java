package com.github.KluevJakov.StoreClosure.repository;

import com.github.KluevJakov.StoreClosure.entity.Changelog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChangelogRepository extends JpaRepository<Changelog, Long> {
    List<Changelog> findAllByStoreId(Long id);
}

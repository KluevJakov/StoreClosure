package com.github.KluevJakov.StoreClosure.repository;

import com.github.KluevJakov.StoreClosure.entity.Changelog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangelogRepository extends JpaRepository<Changelog, Long> {

}

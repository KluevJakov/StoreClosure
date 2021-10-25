package com.github.KluevJakov.StoreClosure.repository;

import com.github.KluevJakov.StoreClosure.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}

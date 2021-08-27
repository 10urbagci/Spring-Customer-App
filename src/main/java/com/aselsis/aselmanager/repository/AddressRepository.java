package com.aselsis.aselmanager.repository;

import com.aselsis.aselmanager.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}

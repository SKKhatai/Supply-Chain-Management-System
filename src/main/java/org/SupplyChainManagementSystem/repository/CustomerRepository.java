package org.SupplyChainManagementSystem.repository;

import org.SupplyChainManagementSystem.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}

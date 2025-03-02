package org.SupplyChainManagementSystem.repository;



import java.util.List;
import java.util.Optional;

import org.SupplyChainManagementSystem.Entity.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	
	List<Orders> findByCustomerId(int customerId);
	Optional<Orders> findByTrackingNumber(String trackingNumber);


}

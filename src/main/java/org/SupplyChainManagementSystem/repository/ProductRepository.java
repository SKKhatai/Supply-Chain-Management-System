package org.SupplyChainManagementSystem.repository;

import java.util.List;

import org.SupplyChainManagementSystem.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findBySupplierId(int supplierId);
}

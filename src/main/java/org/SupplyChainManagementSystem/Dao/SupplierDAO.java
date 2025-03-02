package org.SupplyChainManagementSystem.Dao;

import java.util.List;
import java.util.Optional;

import org.SupplyChainManagementSystem.Entity.Supplier;
import org.SupplyChainManagementSystem.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SupplierDAO {
	@Autowired
	private SupplierRepository supplierRepository;
	
	public Supplier insertSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	public Optional<Supplier> getSupplierById(int id) {
		return supplierRepository.findById(id);
	}
	
	public List<Supplier> getAllSupplier(){
		return supplierRepository.findAll();
	}
	
	public Supplier updateSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	public void deleteSupplier() {
		supplierRepository.deleteAll();
	}
}

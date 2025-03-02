package org.SupplyChainManagementSystem.Controller;

import java.util.List;

import org.SupplyChainManagementSystem.Dto.ResponseStructure;
import org.SupplyChainManagementSystem.Entity.Supplier;
import org.SupplyChainManagementSystem.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Supplier>> saveSupplier(@RequestBody Supplier supplier){
		return supplierService.saveSupplier(supplier);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Supplier>> getSupplierById(@PathVariable int id){
		return supplierService.getSupplierById(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Supplier>>> getAllSupplier(){
		return supplierService.getAllSupplier();
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Supplier>> updateSupplier(@RequestBody Supplier supplier){
		return supplierService.updateSupplier(supplier);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Supplier>> deleteSupplier(){
		return supplierService.deleteSupplier();
	}

}

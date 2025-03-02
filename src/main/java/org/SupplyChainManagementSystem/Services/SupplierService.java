package org.SupplyChainManagementSystem.Services;

import java.util.List;
import java.util.Optional;

import org.SupplyChainManagementSystem.Dao.SupplierDAO;
import org.SupplyChainManagementSystem.Dto.ResponseStructure;
import org.SupplyChainManagementSystem.Entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierDAO supplierdao;
	
	public ResponseEntity<ResponseStructure<Supplier>> saveSupplier(Supplier supplier){
		ResponseStructure<Supplier> structure= new ResponseStructure<>();
		Supplier savedSupplier=supplierdao.insertSupplier(supplier);
		structure.setData(savedSupplier);
		structure.setMessage("inserted Successfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Supplier>>(HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Supplier>> getSupplierById(int id){
		Optional<Supplier> opt=supplierdao.getSupplierById(id);
		ResponseStructure<Supplier> structure=new ResponseStructure<>();
		if(opt.isPresent()) {
			structure.setMessage("fetched Successfully");
			structure.setData(opt.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.OK);
		}
		else {
			structure.setMessage("fetcing Unsuccessful");
			structure.setData(null);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.NOT_FOUND);
		}
		
	}
	
	public ResponseEntity<ResponseStructure<List<Supplier>>> getAllSupplier(){
		List<Supplier> list=supplierdao.getAllSupplier();
		ResponseStructure<List<Supplier>> structure=new ResponseStructure<>();

		structure.setMessage("fetched Successfully");
		structure.setData(list);
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Supplier>>>(structure,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<Supplier>> updateSupplier(Supplier supplier){
		ResponseStructure<Supplier> structure=new ResponseStructure<>();
		supplierdao.updateSupplier(supplier);
		structure.setMessage("Update Successfully");
		structure.setData(supplier);
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Supplier>> deleteSupplier(){
		ResponseStructure<Supplier> structure=new ResponseStructure<>();
		supplierdao.deleteSupplier();
		structure.setMessage("Deleted Successfully");
		structure.setData(null);
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.OK);
	}
	

}

package org.SupplyChainManagementSystem.Controller;

import java.util.List;

import org.SupplyChainManagementSystem.Dto.ResponseStructure;

import org.SupplyChainManagementSystem.Entity.Customer;
import org.SupplyChainManagementSystem.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer){
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<ResponseStructure<Customer>> findCustomerById(@PathVariable int id){
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllDetails(){
		return customerService.getAllCustomerDetails();
	}
	
	@PutMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomerDetails(@RequestBody Customer customer){
		return customerService.saveCustomer(customer);
	}
	
	@DeleteMapping("/customer/delete/all")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@RequestBody Customer customer){
		return customerService.deleteCustomer(customer);
	}
	

}

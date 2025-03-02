package org.SupplyChainManagementSystem.Dao;

import java.util.List;
import java.util.Optional;

import org.SupplyChainManagementSystem.Entity.Customer;
import org.SupplyChainManagementSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Optional<Customer> findCustomerById(int id){
		return customerRepository.findById(id);
	}
	
	public List<Customer> getAllCustomerDetail(){
		return customerRepository.findAll();
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void  deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	public void deleteAllCustomer() {
		customerRepository.deleteAll();
	}
}

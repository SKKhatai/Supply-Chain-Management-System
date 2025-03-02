package org.SupplyChainManagementSystem.Services;

import java.util.List;
import java.util.Optional;

import org.SupplyChainManagementSystem.Dao.CustomerDAO;
import org.SupplyChainManagementSystem.Dto.ResponseStructure;
import org.SupplyChainManagementSystem.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	public ResponseEntity<ResponseStructure<Customer>>  saveCustomer(Customer customer){
		Customer receivedCustomer=customerDAO.saveCustomer(customer);
		ResponseStructure<Customer> struct=new ResponseStructure<>();
		struct.setData(receivedCustomer);
		struct.setMessage("inserted Successfully");
		struct.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Customer>>(struct,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int id){
		Optional<Customer> opt=customerDAO.findCustomerById(id);
		ResponseStructure<Customer> struct=new ResponseStructure<>();
		if(opt.isPresent()) {
			struct.setData(opt.get());
			struct.setMessage("fetched Successfully");
			struct.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Customer>>(struct, HttpStatus.ACCEPTED);
		}
		else {
			struct.setData(null);
			struct.setMessage("fetching UnSuccessful");
			struct.setStatusCode(HttpStatus.NO_CONTENT.value());
			return new ResponseEntity<ResponseStructure<Customer>>(struct,HttpStatus.ACCEPTED);

		}
	}
	
	
	
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomerDetails(){
		
		List<Customer> list=customerDAO.getAllCustomerDetail();
		ResponseStructure<List<Customer>> struct=new ResponseStructure<>();
		
		struct.setData(list);
		struct.setMessage("fetching UnSuccessful");
		struct.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Customer>>>(struct,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer){
		ResponseStructure<Customer> struct=new ResponseStructure<>();
		customerDAO.saveCustomer(customer);
		struct.setData(customer);
		struct.setMessage("update Successful");
		struct.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Customer>>(struct,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(Customer customer){
		ResponseStructure<Customer> struct=new ResponseStructure<>();
		customerDAO.deleteAllCustomer();
		struct.setData(customer);
		struct.setMessage("Deletion Successful");
		struct.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Customer>>(struct,HttpStatus.OK);
	}
}

package org.SupplyChainManagementSystem.Services;

import java.util.List;
import java.util.Optional;

import org.SupplyChainManagementSystem.Dao.CustomerDAO;
import org.SupplyChainManagementSystem.Dao.OrdersDAO;
import org.SupplyChainManagementSystem.Dto.ResponseStructure;
import org.SupplyChainManagementSystem.Entity.Customer;
import org.SupplyChainManagementSystem.Entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
	@Autowired
	private OrdersDAO ordersdao;
	
	@Autowired
	private CustomerDAO customerDao;
	
	public ResponseEntity<ResponseStructure<Orders>> createOrders(int customerId,Orders orders){
		
		Optional<Customer> customer=customerDao.findCustomerById(customerId);
		
		
		if(!customer.isPresent()) {
			ResponseStructure<Orders> structure=new ResponseStructure<>();

			structure.setMessage("Customer not found! cannot create order.");
			structure.setData(null);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.NOT_FOUND);
		}
		
		orders.setCustomer(customer.get());
		Orders saveOrders=ordersdao.createOrder(orders);
		ResponseStructure<Orders> structure=new ResponseStructure<>();
		ordersdao.createOrder(saveOrders);
		structure.setMessage("Order Created Successfully");
		structure.setData(saveOrders);
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Orders>> getCustomersById(int id){
		Optional<Orders> opt=ordersdao.getOrdersById(id);
		ResponseStructure<Orders> structure=new ResponseStructure<>();
		if(opt.isPresent()) {
			structure.setMessage("Fetch Successfully");
			structure.setData(opt.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.OK);
		}
		else {
			structure.setMessage("Fetch UnSuccessfull");
			structure.setData(null);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders(){
		List<Orders> list=ordersdao.getAllOrders();
		ResponseStructure<List<Orders>> structure=new ResponseStructure<>();
		structure.setMessage("Fetch Successfully");
		structure.setData(list);
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Orders>>>(structure,HttpStatus.OK);

	}
	
	public ResponseEntity<ResponseStructure<Orders>> updateOrders(Orders orders){
		ordersdao.updateOrder(orders);
		ResponseStructure<Orders> structure=new ResponseStructure<>();
		structure.setMessage("Update Successfully");
		structure.setData(orders);
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Orders>> deleteAllOrders(Orders orders){
		ordersdao.deleteAllOrder();
		ResponseStructure<Orders> structure=new ResponseStructure<>();
		structure.setMessage("Delete Successfully");
		structure.setData(orders);
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Orders>>> getOrderByCustomerId(int customerId){
		List<Orders> orders =ordersdao.getOrdersByCustomerId(customerId);
		ResponseStructure<List<Orders>> structure=new ResponseStructure<>();
		
		if(orders.isEmpty()) {
			structure.setMessage("No Orders Found For this customer");
			structure.setData(null);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Orders>>>(structure,HttpStatus.NOT_FOUND);
		}
		structure.setMessage("Orders Retrival Successfully");
		structure.setData(orders);
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Orders>>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Orders>> getOrderByTrackingNumber(String trackingNumber){
		Optional<Orders> opt=ordersdao.getOrderByTrackingNumber(trackingNumber);
		ResponseStructure<Orders> structure=new ResponseStructure<>();
		if(opt.isPresent()) {
			structure.setMessage("Orders successfully found using Tracking NUmber");
			structure.setData(opt.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.OK);
		}
		else {
			structure.setMessage("Orders Not Found using TrackingNumber");
			structure.setData(null);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.NOT_FOUND);
		
		}
		
	}
	
}

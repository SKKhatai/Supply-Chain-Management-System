package org.SupplyChainManagementSystem.Controller;

import java.util.List;

import org.SupplyChainManagementSystem.Dto.ResponseStructure;
import org.SupplyChainManagementSystem.Entity.Orders;
import org.SupplyChainManagementSystem.Services.OrdersService;
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
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@PostMapping("/orders/customers/{id}")
	public ResponseEntity<ResponseStructure<Orders>> createOrders(@PathVariable int id,@RequestBody Orders orders){
		return ordersService.createOrders(id,orders);
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<ResponseStructure<Orders>> getOrdersById(@PathVariable int id){
		return ordersService.getCustomersById(id);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders(){
		return ordersService.getAllOrders();
	}
	
	@PutMapping("/orders")
	public ResponseEntity<ResponseStructure<Orders>> updateOrders(@RequestBody Orders order){
		return ordersService.updateOrders(order);
	}
	
	@DeleteMapping("/orders/delete/all")
	public ResponseEntity<ResponseStructure<Orders>> deleteAllorder(@RequestBody Orders orders){
		return ordersService.deleteAllOrders(orders);
	}
	@GetMapping("orders/customers/{customerId}")
	public ResponseEntity<ResponseStructure<List<Orders>>> getOrderByCustomerId(@PathVariable int customerId){
		return ordersService.getOrderByCustomerId(customerId);
	}
	@GetMapping("orders/tracking/{trackingNumber}")
	public ResponseEntity<ResponseStructure<Orders>> getOrderByTrackingNumber(@PathVariable String trackingNumber){
		return ordersService.getOrderByTrackingNumber(trackingNumber);
	}
}

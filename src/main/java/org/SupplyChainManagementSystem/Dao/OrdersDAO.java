package org.SupplyChainManagementSystem.Dao;

import java.util.List;
import java.util.Optional;

import org.SupplyChainManagementSystem.Entity.Orders;
import org.SupplyChainManagementSystem.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDAO {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	public Orders createOrder(Orders order) {
		return ordersRepository.save(order);
	}
	
	public Optional<Orders> getOrdersById(int id){
		return ordersRepository.findById(id);
	}
	
	public List<Orders> getAllOrders(){
		return ordersRepository.findAll();
	}
	
	public Orders updateOrder(Orders order) {
		return ordersRepository.save(order);
	}
	
	public  void deleteAllOrder() {
		 ordersRepository.deleteAll();
	}
	
	public List<Orders> getOrdersByCustomerId(int customerId){
		return ordersRepository.findByCustomerId(customerId);
	}
	public Optional<Orders> getOrderByTrackingNumber(String trackingNumber){
		return ordersRepository.findByTrackingNumber(trackingNumber);
	}
}

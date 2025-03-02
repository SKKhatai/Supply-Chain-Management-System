package org.SupplyChainManagementSystem.Dao;

import java.util.List;
import java.util.Optional;

import org.SupplyChainManagementSystem.Dto.ResponseStructure;
import org.SupplyChainManagementSystem.Entity.Product;
import org.SupplyChainManagementSystem.Services.ProductService;
import org.SupplyChainManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class ProductDAO {
	@Autowired
	private ProductRepository productRepository;
	
	public Product AddProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Optional<Product> getProductById(int id) {
		return productRepository.findById(id);
	}
	
	public List<Product> getAllProductDetails() {
		return productRepository.findAll();
	}
	
	public Product updateProductDetail(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteAllProduct() {
		 productRepository.deleteAll();;
	}
	
	public List<Product> getProductBySupplierId(int supplierId){
		return productRepository.findBySupplierId(supplierId);
	}
	
}

package org.SupplyChainManagementSystem.Controller;

import java.util.List;

import org.SupplyChainManagementSystem.Dto.ResponseStructure;
import org.SupplyChainManagementSystem.Entity.Product;
import org.SupplyChainManagementSystem.Services.ProductService;
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
@RequestMapping("/product")
public class ProductController {
	@Autowired
	 private ProductService productService;
	 
	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable int id){
		return productService.getProductById(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct(){
		return productService.getAllProductDetail();
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Product>> updateProductDetail(@RequestBody Product product){
		return productService.updateProduct(product);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@RequestBody Product product){
		return productService.deleteAllProduct(product);
	}
	@GetMapping("supplier/{supplierId}")
	public ResponseEntity<ResponseStructure<List<Product>>> getProductsBySupplierId(@PathVariable int supplierId){
		return productService.getProductBySupplierId(supplierId);
	}
}

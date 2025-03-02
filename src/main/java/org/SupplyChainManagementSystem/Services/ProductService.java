package org.SupplyChainManagementSystem.Services;

import java.util.List;
import java.util.Optional;

import org.SupplyChainManagementSystem.Dao.ProductDAO;
import org.SupplyChainManagementSystem.Dto.ResponseStructure;
import org.SupplyChainManagementSystem.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productdao;
	
	public ResponseEntity<ResponseStructure<Product>> addProduct(Product product){
		ResponseStructure<Product> structure=new ResponseStructure<>();
		productdao.AddProduct(product);
		structure.setData(product);
		structure.setMessage("Added Successfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Product>> getProductById(int id){
		Optional<Product> opt=productdao.getProductById(id);
		ResponseStructure<Product> structure=new ResponseStructure<>();
		if(opt.isPresent()) {
			structure.setData(opt.get());
			structure.setMessage("Fetched Successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		else {
			structure.setData(null);
			structure.setMessage("Fetching UnSuccessful");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProductDetail(){
		ResponseStructure<List<Product>> structure=new ResponseStructure<>();
		List<Product> list=productdao.getAllProductDetails();

		structure.setData(list);
		structure.setMessage("Fetched Successfully");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product){
		ResponseStructure<Product> structure=new ResponseStructure<>();
		productdao.updateProductDetail(product);
		structure.setData(product);
		structure.setMessage("Updated Successfully");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Product>> deleteAllProduct(Product product){
		ResponseStructure<Product> structure=new ResponseStructure<>();
		productdao.deleteAllProduct();

		structure.setData(null);
		structure.setMessage("Deleted Successfully");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> getProductBySupplierId(int  supplierId){
		List<Product> opt=productdao.getProductBySupplierId(supplierId);
		ResponseStructure<List<Product>> structure=new ResponseStructure<>();
		
		if(opt.isEmpty()) {
			structure.setData(null);
			structure.setMessage("Fetching UnSuccessfull");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.NOT_FOUND);
		}
		structure.setData(opt);
		structure.setMessage("Fetching Successfull");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
	}
	
}

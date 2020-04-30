package com.restApiPract2.crud.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restApiPract2.crud.example.entity.Product;
import com.restApiPract2.crud.example.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	public List<Product> saveProducts(List<Product> products){
		return (List<Product>) productRepository.saveAll(products);
	}
	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}
	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}
	 public List<Product> getProducts() {
	    return (List<Product>) productRepository.findAll();
	}
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "product is deleted";
	}
	public Product updateProduct(Product product) {
		Product existenceProduct=productRepository.findById(product.getId()).orElse(null);
		existenceProduct.setName(product.getName());
		existenceProduct.setPrice(product.getPrice());
		existenceProduct.setQuantity(product.getQuantity());
		return productRepository.save(product);
	}

}

package tdtu.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tdtu.edu.demo.entity.Product;
import tdtu.edu.demo.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> listAll(){
		return productRepository.findAll();
	}
	
	public void save(Product product) {
		productRepository.save(product);
	}
	
	public Product getProductById(Integer id) {
		return productRepository.findById(id).get();
	}
	
	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);
	}
}

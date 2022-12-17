package tdtu.edu.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tdtu.edu.demo.entity.Product;
import tdtu.edu.demo.repository.ProductRepository;
import tdtu.edu.demo.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping({"product/list-product", "product/"})
	public String showProduct(Model model) {
		List<Product> listProducts = productService.listAll();
		model.addAttribute("products", listProducts);
		
		return "product/list-product";
	}
	
	@GetMapping("product/add-product")
	public String addProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "product/add-product";
	}
	
	@PostMapping("/save-product")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.save(product);
		
		return "redirect:/product/list-product";
	}
	
	@RequestMapping("product/view-product/{id}")
	public String viewProduct(@PathVariable("id") int id, Model model) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			model.addAttribute("product", product.get());
		}
		return "product/view-product";
	}
	
	@RequestMapping("product/update-product/{id}")
	public String updateProduct(@PathVariable int id, Model model) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			model.addAttribute("product", product.get());
		}
		return "product/update-product";
	}
	
	@RequestMapping("product/updateProduct")
	public String doUpdateProduct(@ModelAttribute("Product") Product product, Model model) {
		productRepository.save(product);
		model.addAttribute("product/list-product", productRepository.findAll());
		return "redirect:/product/list-product";
	}
	
	@RequestMapping("product/delete/{id}")
	public String deleteProductByID(@PathVariable("id") int id) {
		productService.deleteProductById(id);
		return "redirect:/product/list-product";
	}
}

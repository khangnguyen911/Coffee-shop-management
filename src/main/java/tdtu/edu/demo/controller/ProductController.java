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
import org.springframework.web.servlet.ModelAndView;

import tdtu.edu.demo.entities.Product;
import tdtu.edu.demo.repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping({"product/list-product", "product/"})
	public ModelAndView showProduct() {
		ModelAndView modelAndView = new ModelAndView("product/list-product");
		List<Product> listProducts = productRepository.findAll();
		modelAndView.addObject("products", listProducts);
		return modelAndView;
	}
	
	@GetMapping("product/add-product")
	public ModelAndView addProductForm() {
		ModelAndView modelAndView = new ModelAndView("product/add-product");
		Product newProduct = new Product();
		modelAndView.addObject("product", newProduct);
		return modelAndView;
	}
	
	@PostMapping("/save-product")
	public String saveProduct(@ModelAttribute Product product) {
		productRepository.save(product);
		
		return "redirect:/product/list-product";
	}
	
	@RequestMapping("product/view-product/{id}")
	public String viewProduct(@PathVariable int id, Model model) {
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
	
//	@RequestMapping("employee/employeeDelete/{id}")
//	public String doDeleteProduct(@PathVariable int id, Model model) {
//		productRepository.deleteById(id);
//		model.addAttribute("listProduct", productRepository.findAll());
//		return "redirect:/product/list-product";
//	}
}

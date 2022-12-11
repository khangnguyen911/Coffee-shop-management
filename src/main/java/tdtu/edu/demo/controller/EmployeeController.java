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

import tdtu.edu.demo.entity.Employee;
import tdtu.edu.demo.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping({"employee/list-employee", "employee/"})
	public ModelAndView showEmployee() {
		ModelAndView modelAndView = new ModelAndView("employee/list-employee");
		List<Employee> listEmployees = employeeRepository.findAll();
		modelAndView.addObject("employees", listEmployees);
		return modelAndView;
	}
	
	@GetMapping("employee/add-employee")
	public ModelAndView addEmployeeForm() {
		ModelAndView modelAndView = new ModelAndView("employee/add-employee");
		Employee newEmployee = new Employee();
		modelAndView.addObject("employee", newEmployee);
		return modelAndView;
	}
	
	@PostMapping("/save-employee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeRepository.save(employee);
		
		return "redirect:/employee/list-employee";
	}
	
	@RequestMapping("employee/view-employee/{id}")
	public String viewEmployee(@PathVariable int id, Model model) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			model.addAttribute("employee", employee.get());
		}
		return "employee/view-employee";
	}

	@RequestMapping("employee/update-employee/{id}")
	public String updateEmployee(@PathVariable int id, Model model) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			model.addAttribute("employee", employee.get());
		}
		return "employee/update-employee";
	}
	
	@RequestMapping("employee/updateEmployee")
	public String doUpdateEmployee(@ModelAttribute("Employee") Employee employee, Model model) {
		employeeRepository.save(employee);
		model.addAttribute("employee/list-employee", employeeRepository.findAll());
		return "redirect:/employee/list-employee";
	}
	
	@RequestMapping("employee/employeeDelete/{id}")
	public String doDeleteEmployee(@PathVariable int id, Model model) {
		employeeRepository.deleteById(id);
		model.addAttribute("listEmployee", employeeRepository.findAll());
		return "redirect:/employee/list-employee";
	}
	
	@RequestMapping("/403")
	public String error() {
		return "403";
	}
}

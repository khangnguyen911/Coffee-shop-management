package com.tdtu.THANH19.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tdtu.THANH19.entities.Employee;
import com.tdtu.THANH19.repositories.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(value = { "/", "/employee-list" })
	public String listEmployee(Model model) {
		model.addAttribute("listEmployee", employeeRepository.findAll());
		return "employee-list";
	}

	@RequestMapping("/employee-save")
	public String insertEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee-save";
	}

	@RequestMapping("/employee-view/{id}")
	public String viewEmployee(@PathVariable int id, Model model) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			model.addAttribute("employee", employee.get());
		}
		return "employee-view";
	}

	@RequestMapping("/employee-update/{id}")
	public String updateEmployee(@PathVariable int id, Model model) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			model.addAttribute("employee", employee.get());
		}
		return "employee-update";
	}

	@RequestMapping("/saveEmployee")
	public String doSaveEmployee(@ModelAttribute("Employee") Employee employee, Model model) {
		employeeRepository.save(employee);
		model.addAttribute("listEmployee", employeeRepository.findAll());
		return "employee-list";
	}

	@RequestMapping("/updateEmployee")
	public String doUpdateCustomer(@ModelAttribute("Employee") Employee employee, Model model) {
		employeeRepository.save(employee);
		model.addAttribute("listEmployee", employeeRepository.findAll());
		return "employee-list";
	}

	@RequestMapping("/customerDelete/{id}")
	public String doDeleteCustomer(@PathVariable int id, Model model) {
		employeeRepository.deleteById(id);
		model.addAttribute("listEmployee", employeeRepository.findAll());
		return "employee-list";
	}
}

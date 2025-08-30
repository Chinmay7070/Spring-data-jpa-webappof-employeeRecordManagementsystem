package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgtService;

@Controller
public class EmployeOperationController {

	
	@Autowired
	private IEmployeeMgtService service;
	@GetMapping("/")
   public String showHowe() {
	   return "welcome";
   }
	
	@GetMapping("/report")
	public String showReport(Map<String,Object> map) {
		List<Employee> emplist = service.fetchAllEmp();
		map.put("resultinfo", emplist);
		return "show_report";
		
	}
	
	@GetMapping("/register")
	public String showregisterEmployee(@ModelAttribute("emp") Employee emp)
	{
		return "employee_register_form";
	}
	
	@PostMapping("/register")
	public String processRegisterEmp(Map<String,Object>map,@ModelAttribute("emp") Employee emp) {
		String msg = service.registerEmployee(emp);
		map.put("resultMsg", msg);
		return "show_report";
	}
	
	
}

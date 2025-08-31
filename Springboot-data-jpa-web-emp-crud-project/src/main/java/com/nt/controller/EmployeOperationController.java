 package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgtService;

import jakarta.servlet.http.HttpSession;

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
	
	/*	@PostMapping("/register")
		public String processRegisterEmp(Map<String,Object>map,@ModelAttribute("emp") Employee emp) {
			String msg = service.registerEmployee(emp);
			List<Employee> list = service.fetchAllEmp();
			map.put("resultMsg", msg);
			map.put("resultinfo", list);
			return "show_report";
		}*/
	/*
	@PostMapping("/register")
	public String processRegisterEmp(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp) {
		String msg = service.registerEmployee(emp);
		
		attrs.addFlashAttribute("resultMsg", msg);
	
		return "redirect:report";
	}*/
	

	@PostMapping("/register")
	public String processRegisterEmp(HttpSession ses,@ModelAttribute("emp") Employee emp) {
		String msg = service.registerEmployee(emp);
		
		ses.setAttribute("resultMsg", msg);
	
		return "redirect:report";
	}
	
	@GetMapping("/edit")
	public String showEditformPage(@RequestParam("no") int no,@ModelAttribute("emp") Employee emp) {
		
		Employee emp1 = service.getEmpByNo(no);
		BeanUtils.copyProperties(emp1, emp);
		return "emp_edit_form";	
	}
	@PostMapping("/edit")
	public String showEditformPage(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp) {
		
		String msg = service.updateEmployee(emp);
		 attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:report";	
	}
	
	@GetMapping("/delete")
	public String deletEmpByNo(@RequestParam("no") int no,RedirectAttributes attrs) {
		String msg = service.deleteEmp(no);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
}

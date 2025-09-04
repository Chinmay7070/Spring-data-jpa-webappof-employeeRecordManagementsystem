package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;   // ✅ correct
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgtService;
import com.nt.validate.EmployeeValidator;

import jakarta.servlet.http.HttpSession;


@Controller
public class EmployeOperationController {

	@Autowired
	private EmployeeValidator empValidator;
	@Autowired
	private IEmployeeMgtService service;
	@Autowired
	private IEmployeeMgtService dservice;
	@GetMapping("/")
   public String showHowe() {
	   return "welcome";
   }
	
	@GetMapping("/report_pagination")
	public String showReportByPagination(
	        Map<String, Object> map,
	        @PageableDefault(page = 0, size = 3, sort = "job", direction = Sort.Direction.ASC) Pageable pageable) {
	    
	    Page<Employee> page = service.showEmployeeByPagination(pageable);
	    map.put("pagedata", page);
	    
	    return "show_report_pagination"; // fixed typo
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
	public String processRegisterEmp(HttpSession ses,@ModelAttribute("emp") Employee emp,BindingResult errors) {
		
		
		if(emp.getVflag1().equalsIgnoreCase("no")) {
			if(empValidator.supports(emp.getClass())) {
				empValidator.validate(emp, errors);
				if(errors.hasErrors()) {
					return "employee_register_form";
				}
			}
		}
		
		
		if(service.isDesigInRejectedList(emp.getJob())) {
			errors.rejectValue("job","emp.desg.reject");
			return "employee_register_form";
		}
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
	public String showEditformPage(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp,BindingResult errors) {
		
		if(emp.getVflag1().equalsIgnoreCase("no")) {
		if(empValidator.supports(emp.getClass())) {
			empValidator.validate(emp, errors);
			if(errors.hasErrors()) {
				return "employee_register_form";
			}
		}
		}
		
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
	
	@ModelAttribute("dnoList")
	public List<Integer> populateDeptsNmaes(){
		List<Integer> dnoListe = dservice. showAllDeptNo();
		return dnoListe;
	}
	
	
	
	
}

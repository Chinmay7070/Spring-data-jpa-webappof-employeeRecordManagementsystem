package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgtService {

	public List<Employee> fetchAllEmp();
	
	public String registerEmployee(Employee emp);
}

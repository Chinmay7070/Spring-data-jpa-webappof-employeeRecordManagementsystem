package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgtImpl implements IEmployeeMgtService {

	@Autowired
	private IEmployeeRepo emprepo;
	@Override
	public List<Employee> fetchAllEmp() {
		
		return emprepo.findAll();
	}
	@Override
	public String registerEmployee(Employee emp) {
		
		int idval = emprepo.save(emp).getEmpno();
		
		return "Employee is save with ="+idval;
	}

}

package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IDepartmanetRepo;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgtImpl implements IEmployeeMgtService {

	@Autowired
	private IEmployeeRepo emprepo;
	@Autowired
	private IDepartmanetRepo deptrepo;
	@Override
	public List<Employee> fetchAllEmp() {
		
		return emprepo.findAll();
	}
	@Override
	public String registerEmployee(Employee emp) {
		
		int idval = emprepo.save(emp).getEmpno();
		
		return "Employee is save with ="+idval;
	}
	@Override
	public Employee getEmpByNo(int no) {
		Employee emp = emprepo.getReferenceById(no);
	    return emp;
	}
	
	@Override
	public String updateEmployee(Employee emp) {
		Optional<Employee> opt = emprepo.findById(emp.getEmpno());
		if(opt.isPresent()) {
			emprepo.save(emp);
			return emp.getEmpno()+"employeed is updated";
			 
		}
		return emp.getEmpno()+"employee si not avalable for the updation";
		
	}
	@Override
	public String deleteEmp(int no) {
		emprepo.deleteById(no);
		return "Employee is deleted ";
	}
	@Override
	public List<Integer> showAllDeptNo() {
		List<Integer> list = deptrepo.fetchAllDeptNo();
		return list;
	}

}

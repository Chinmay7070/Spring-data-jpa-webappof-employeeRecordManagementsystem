package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.model.Employee;

public interface IEmployeeMgtService {

    public List<Employee> fetchAllEmp();

    public String registerEmployee(Employee emp);

    public Employee getEmpByNo(int no);

    public String updateEmployee(Employee emp);

    public String deleteEmp(int no);

    public List<Integer> showAllDeptNo();

    public boolean isDesigInRejectedList(String desg);

    public Page<Employee> showEmployeeByPagination(Pageable pageable);

}

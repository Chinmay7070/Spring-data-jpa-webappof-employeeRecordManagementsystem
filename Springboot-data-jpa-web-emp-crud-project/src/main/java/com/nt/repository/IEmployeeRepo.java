package com.nt.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee,Integer>{


}

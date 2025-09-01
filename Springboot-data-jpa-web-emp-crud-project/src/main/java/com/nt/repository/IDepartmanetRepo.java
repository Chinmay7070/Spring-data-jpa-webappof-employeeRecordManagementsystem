package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.model.Dept;

public interface IDepartmanetRepo extends JpaRepository<Dept,Integer> {

	@Query("select deptno from Dept")
	public List<Integer> fetchAllDeptNo();
	
}

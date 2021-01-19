package com.sample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.demo.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
	
	
	@Query("update employee set deleteStatus=true where id=:?")
	public Employee deleteEmployeeById(@Param("id")Integer id);
	
}

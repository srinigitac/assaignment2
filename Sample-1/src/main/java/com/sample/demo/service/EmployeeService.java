package com.sample.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.entity.Employee;
import com.sample.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> save(List<Employee> entities){
		
		return employeeRepository.saveAll(entities);
	}
	
	public List<Employee> getAllEmployee(){
		
		return  employeeRepository.findAll();
	} 
	
	
	public Employee updateEmployee(Employee emp){
		
		Optional<Employee> obj=employeeRepository.findById(emp.getId());
		Employee empResult=null;
		if(obj.isPresent()) {
			Employee empRepo=obj.get();
			empRepo.setFirstName(emp.getFirstName());
			empRepo.setLastName(emp.getLastName());
			empRepo.setEmailId(emp.getEmailId());
			empRepo.setAddress(emp.getAddress());
			empRepo.setAge(emp.getAge());
			empRepo.setGender(emp.getGender());
			empResult=employeeRepository.save(empRepo);
		}
		
		return empResult;
	} 
	public String deleteEmployee(Integer Id){
		
		Employee empl=employeeRepository.deleteEmployeeById(Id);
		if(empl.isDeleteStatus()==true) {
			return "Success";
		}else
			return "Failed";
		
		
	} 
}

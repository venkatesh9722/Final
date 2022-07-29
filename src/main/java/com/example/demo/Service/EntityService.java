package com.example.demo.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Entity.Mini;
import com.example.demo.Exception.EmployeeAlreadyExist;
import com.example.demo.Exception.NoSuchEmployeeExistsException;
import com.example.demo.Repository.EntityRepository;



@Service
public class EntityService {

	private static final int list=0;
	
	@Autowired
	private EntityRepository repo;
	
	public Mini addEntity(Mini mini) throws EmployeeAlreadyExist{
		Mini existing=repo.findById(mini.getId()).orElse(null);
		if(existing == null) {
			return repo.save(mini);
		}else 		
			throw new EmployeeAlreadyExist("Employee Already Exist");
	}
	
	public List<Mini> getAllEmployees(){
		return repo.findAll();
	}
	
	public List<Mini> getEmployeeByDesOrderOfSalary(){
		List<Mini> list=repo.findAll();
		return list;
	}
	
	public List<Mini> getEmpInDes(){
		List<Mini> es=repo.findAll();
		return es;
	}
	
	public Mini getById(int id) throws NoSuchEmployeeExistsException{
		Mini mini =repo.findById(id).orElse(null);
		if(mini != null) {
			return mini;
		}else {
			throw new NoSuchEmployeeExistsException("user not found with id");
		}
	}
	public Mini editMini(Mini me) {
		Mini existing=repo.findById(me.getId()).orElse(null);
		existing.setName(me.getName());
		existing.setSalary(me.getSalary());
		return repo.save(existing);
	}
	
	public Mini editEmpBySalary(int id,double salary) {
	Mini emp=repo.findById(id).orElse(null);
	emp.setSalary(salary);
	return repo.save(emp);
	}
	
	public Mini saveMini(Mini mini) {
		// TODO Auto-generated method stub
		return repo.save(mini);
	}
}

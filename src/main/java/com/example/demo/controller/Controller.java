package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Mini;
import com.example.demo.Exception.EmployeeAlreadyExist;
import com.example.demo.Exception.NoSuchEmployeeExistsException;
import com.example.demo.Service.EntityService;

@RestController
public class Controller {

	@Autowired
	private EntityService service;
	@PostMapping("/employee")
	public ResponseEntity<Mini> saveEntity(@RequestBody @Validated Mini m) throws EmployeeAlreadyExist{
				 return  new ResponseEntity<>(service.addEntity(m), HttpStatus.CREATED);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Mini> getById(@PathVariable int id) throws NoSuchEmployeeExistsException
	{
		return ResponseEntity.ok(service.getById(id));
	}
	
	@PostMapping("/employees")
	public Mini addEmployee(@RequestBody Mini mini) {
		return service.saveMini(mini);
	}
	@GetMapping("/employees")
	public ResponseEntity<List<Mini>> getAllEmployee()
	{
		return ResponseEntity.ok(service.getAllEmployees());
	}
	@PutMapping("/employee")
	public Mini editEmp(@RequestBody @Validated Mini e) {
		return service.editMini(e);
	}
	@PutMapping("/employee/{id}/{salary}")
	public Mini editEmployeeBysalary(@PathVariable int id,@PathVariable double salary) {
		return service.editEmpBySalary(id, salary);
	}
	
}
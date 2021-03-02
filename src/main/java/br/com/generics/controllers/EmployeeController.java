package br.com.generics.controllers;

import br.com.generics.dto.EmployeeDTO;
import br.com.generics.entities.Employee;
import br.com.generics.services.EmployeeService;
import br.com.generics.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	private GenericService<Employee, EmployeeDTO, Long> service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
		EmployeeDTO obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> findAll(){
		List<EmployeeDTO> employeeDTOList = service.findAll();
		return ResponseEntity.ok(employeeDTOList);
	}
}

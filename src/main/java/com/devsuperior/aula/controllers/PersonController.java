package com.devsuperior.aula.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.services.PersonService;

@RestController
@RequestMapping(value = "/people")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	//INSERT
		//@PostMapping
		public ResponseEntity<PersonDepartmentDTO> insert(@RequestBody PersonDepartmentDTO dto) {
			dto = service.insert(dto);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();//RESPOSTA CUSTOMIZADA '201' COM RESPONSEENTITY
			return ResponseEntity.created(uri).body(dto);
		}
		
	//INSERT
		@PostMapping
		public ResponseEntity<PersonDTO> insert(@RequestBody PersonDTO dto) {
				dto = service.insert(dto);
				URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(dto.getId()).toUri();//RESPOSTA CUSTOMIZADA '201' COM RESPONSEENTITY
				return ResponseEntity.created(uri).body(dto);
		}

}

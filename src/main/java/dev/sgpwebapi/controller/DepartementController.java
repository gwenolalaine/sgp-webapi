package dev.sgpwebapi.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpwebapi.entite.Departement;
import dev.sgpwebapi.repository.DepartementRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/departements")
public class DepartementController {
	@Autowired private DepartementRepository departementRepository;
	
	@PostConstruct
	public void initDepartement() {
		departementRepository.save(new Departement("lol"));
	}
	
	@GetMapping
	public List<Departement> listerDepartements(){
		return this.departementRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Departement getDepartement(@PathVariable int id) {
		return this.departementRepository.findOne(id);
	}
}

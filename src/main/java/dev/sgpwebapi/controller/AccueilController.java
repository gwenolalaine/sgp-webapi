package dev.sgpwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpwebapi.entite.Departement;
import dev.sgpwebapi.repository.DepartementRepository;

@RestController
@RequestMapping("/index")
public class AccueilController {
	@Autowired private DepartementRepository departementRepository;
	
	@GetMapping
	public List<Departement> afficherAccueil() {
		return departementRepository.findAll();
	}
}

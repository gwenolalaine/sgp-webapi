package dev.sgpwebapi.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpwebapi.entite.Banque;
import dev.sgpwebapi.entite.Collaborateur;
import dev.sgpwebapi.repository.BanqueRepository;
import dev.sgpwebapi.repository.CollaborateurRepository;
import dev.sgpwebapi.repository.DepartementRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/collaborateurs")
public class CollaborateurController {
	@Autowired CollaborateurRepository collaborateurRepository;
	@Autowired DepartementRepository departementRepository;
	@Autowired BanqueRepository banqueRepository;
	
	@PostConstruct
	public void insertCollab() {
		collaborateurRepository.save(new Collaborateur("name", "prename", "dodo", "dodo", "dodo", true, "dodo", departementRepository.findOne(1), banqueRepository.findOne(1), "A01"));
		collaborateurRepository.save(new Collaborateur("bobo", "lebobo", "arf", "dodo", "dodo", true, "dodo", departementRepository.findOne(1), banqueRepository.findOne(1),"A02"));

	}
	
	@GetMapping
	public List<Collaborateur> listerCollaborateurs(@RequestParam Optional<Integer> departement){
		if(departement.isPresent()) {
			return collaborateurRepository.findByDepartement(departementRepository.findOne(departement.get()));
		}
		
		return this.collaborateurRepository.findAll();
	}
	

	@GetMapping(value="/{matricule}")
	public Collaborateur getCollaborateur(@PathVariable String matricule) {
		return this.collaborateurRepository.findByMatricule(matricule);
	}
	
	@PutMapping(value="/{matricule}")
	public Collaborateur setCollaborateur(@PathVariable String matricule, @RequestBody Collaborateur collaborateur) {
		return this.collaborateurRepository.save(collaborateur);
	}
	
	@GetMapping(value="/{matricule}/banque")
	public Banque getCollaborateurBanque(@PathVariable String matricule) {
		return this.collaborateurRepository.findByMatricule(matricule).getBanque();
	}
	
	@PutMapping(value="/{matricule}/banque")
	public Collaborateur setCollaborateurBanque(@PathVariable String matricule, @RequestBody Banque banque) {
		banqueRepository.save(banque);
		Collaborateur collaborateur = this.collaborateurRepository.findByMatricule(matricule);
		collaborateur.setBanque(banque);
		return this.collaborateurRepository.save(collaborateur);
	}
}

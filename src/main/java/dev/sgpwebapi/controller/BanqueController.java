package dev.sgpwebapi.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpwebapi.entite.Banque;
import dev.sgpwebapi.repository.BanqueRepository;

@CrossOrigin(origins="*")
@RestController
public class BanqueController {
	@Autowired BanqueRepository banqueRepository;
	
	@PostConstruct
	public void insertBanque() {
		banqueRepository.save(new Banque("dodo", "123456", "12345"));
		banqueRepository.save(new Banque("lol", "123456", "12345"));
	}
}

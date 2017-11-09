package dev.sgpwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpwebapi.entite.Collaborateur;
import dev.sgpwebapi.entite.Departement;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer>{
	Collaborateur findByMatricule(String matricule);
	List<Collaborateur> findByDepartement(Departement id_departement);
}

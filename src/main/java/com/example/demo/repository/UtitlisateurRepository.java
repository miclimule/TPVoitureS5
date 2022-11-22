package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Utilisateur;

public interface UtitlisateurRepository extends JpaRepository<Utilisateur, Long>{

	Optional<Utilisateur> findByNomAndMpd(String nom,String mpd);
	
}

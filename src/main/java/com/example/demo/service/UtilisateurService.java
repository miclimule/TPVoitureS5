package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Ids;

import com.example.demo.model.Utilisateur;
import com.example.demo.repository.UtitlisateurRepository;

@Service
public class UtilisateurService {
	
	private final UtitlisateurRepository utitlisateurRepository;

	public UtilisateurService(UtitlisateurRepository utitlisateurRepository) {
		super();
		this.utitlisateurRepository = utitlisateurRepository;
	}

	public Utilisateur registerUser(String login,String password) {
		if (login!=null && password!=null) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setMpd(password);
			utilisateur.setNom(login);
			String tokenString = "i should get the token from postman, how do i get it to here?";
			return utitlisateurRepository.save(utilisateur);
		}
		else {
			return null;
		}
	}
	
	public Utilisateur login(String login,String pwd) {
		return utitlisateurRepository.findByNomAndMpd(login, pwd).orElse(null);
	}
}

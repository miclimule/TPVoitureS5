package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Ids;

import com.example.demo.model.Token;
import com.example.demo.model.Utilisateur;
import com.example.demo.repository.TokenRepository;
import com.example.demo.repository.UtitlisateurRepository;

import metier.HashAlgo;
import metier.HashFunction;

@Service
public class UtilisateurService {
	
	private final UtitlisateurRepository utitlisateurRepository;
	private final TokenRepository tokenRepository ;

	public UtilisateurService(UtitlisateurRepository utitlisateurRepository , TokenRepository tokenRepository) {
		super();
		this.utitlisateurRepository = utitlisateurRepository;
		this.tokenRepository = tokenRepository;
	}

	public Utilisateur registerUser(String login,String password) {
		if (login!=null && password!=null) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setMpd(password);
			utilisateur.setNom(login);
			return utitlisateurRepository.save(utilisateur);
		}
		else {
			return null;
		}
	}
	
	public Utilisateur login(String login,String pwd) {
		Utilisateur utilisateur = new Utilisateur(login,pwd);
		String tokenString = "i should get the token from postman, how do i get it to here?";
		HashFunction hashFunction = new HashFunction();
		Token token = new Token();
		token.setHashText(hashFunction.getHash(tokenString));
		Optional<Utilisateur> user = utitlisateurRepository.findByNomAndMpd(login, pwd);
		if (user.empty() != null) {
			token.setIdUtilisateur(user.get());
			token.setDate(LocalDate.now());
			token.setUtilisateur(user.get());
			tokenRepository.save(token);
			return user.get();
		}
		else {
			return null;
		}
	}
}

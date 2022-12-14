package com.example.demo.model;

import java.time.LocalDate;


@Entity
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur Utilisateur;
	
	public Utilisateur getUtilisateur() {
		return Utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		Utilisateur = utilisateur;
	}

	public String getHashText() {
		return hashText;
	}

	public void setHashText(String hashText) {
		this.hashText = hashText;
	}

	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "hashText")
	private String hashText;

	public Token(long id, Utilisateur idUtilisateur, LocalDate date) {
		this.id = id;
		this.Utilisateur = idUtilisateur;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Utilisateur getIdUtilisateur() {
		return Utilisateur;
	}

	public void setIdUtilisateur(Utilisateur idUtilisateur) {
		this.Utilisateur = idUtilisateur;
	}
 
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Token() {
	}
	
	
	
	
}

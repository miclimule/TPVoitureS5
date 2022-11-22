package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "mpd")
	private String mpd;
	
	
	public Utilisateur(String nom, String mpd) {
		this.nom = nom;
		this.mpd = mpd;
	}
	public Utilisateur(int id, String nom, String mpd) {
		
		this.id = id;
		this.nom = nom;
		this.mpd = mpd;
	}
	public Utilisateur() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMpd() {
		return mpd;
	}
	public void setMpd(String mpd) {
		this.mpd = mpd;
	}
	
}

package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.JoinColumnOrFormula;

@Entity
@Table(name="Kilometrage")
public class Kilometrage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "idVoiture")
	private Voiture voiture;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "debutkm")
	private double debutkm;
	
	@Column(name = "finkm")
	private double finkm;

	public Kilometrage(long id, LocalDate date, double debutkm, double finkm) {
		super();
		this.id = id;
		this.date = date;
		this.debutkm = debutkm;
		this.finkm = finkm;
	}

	public Kilometrage() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getDebutkm() {
		return debutkm;
	}

	public void setDebutkm(double debutkm) {
		this.debutkm = debutkm;
	}

	public double getFinkm() {
		return finkm;
	}

	public void setFinkm(double finkm) {
		this.finkm = finkm;
	}
	
	
}

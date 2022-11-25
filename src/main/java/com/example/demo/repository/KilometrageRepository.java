package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Kilometrage;
import com.example.demo.model.Voiture;

public interface KilometrageRepository extends JpaRepository<Kilometrage, Long>{

	Optional<Kilometrage> findByVoiture(Voiture voiture);
	 
}

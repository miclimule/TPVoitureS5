package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.KilometrageRepository;

@Service
public class KilometrageService {

	private final KilometrageRepository kilometrageRepository;

	public KilometrageService(KilometrageRepository kilometrageRepository) {
		this.kilometrageRepository = kilometrageRepository;
	}
	
}

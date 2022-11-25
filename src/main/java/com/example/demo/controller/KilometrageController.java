package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.repository.KilometrageRepository;
import com.example.demo.service.KilometrageService;

@Controller
public class KilometrageController {

	@Autowired
	private KilometrageRepository kilometrageRepository;
	
	@Autowired
	private final KilometrageService kilometrageService;

	public KilometrageController(KilometrageRepository kilometrageRepository, KilometrageService kilometrageService) {
		this.kilometrageRepository = kilometrageRepository;
		this.kilometrageService = kilometrageService;
	}
	
	
}

package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Voiture;
import com.example.demo.repository.VoitureRepository;

@Service
public class VoitureService {
	
	private final VoitureRepository voitureRepository;

	public VoitureService(VoitureRepository voitureRepository) {
		super();
		this.voitureRepository = voitureRepository;
	}
	
	public List<Voiture> listVoiture(){
		return this.voitureRepository.findAll();
	}
	
}

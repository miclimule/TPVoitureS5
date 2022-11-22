package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.VoitureRepository;

@Service
public class VoitureService {
	
	private final VoitureRepository voitureRepository;

	public VoitureService(VoitureRepository voitureRepository) {
		super();
		this.voitureRepository = voitureRepository;
	}
	
	
	
}

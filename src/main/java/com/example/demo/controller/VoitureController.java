package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.model.Utilisateur;
import com.example.demo.model.Voiture;
import com.example.demo.repository.VoitureRepository;

@Controller
public class VoitureController {

	@Autowired
	private VoitureRepository voitureRepository;
	
	
	@GetMapping("/getAllCar")
	public List<Voiture> getAllUCar(){
		return this.voitureRepository.findAll();
	}
	
	@GetMapping("/getAllCar/{id}")
	public ResponseEntity<Voiture> getAllUserById(@PathVariable(name = "id")long id) throws RessourceNotFoundException{
		Voiture car = voitureRepository.findById(id)
		.orElseThrow( () -> new RessourceNotFoundException("Utilisateur "+ id + " pas trouver"));
		return ResponseEntity.ok().body(car);
	}
	
	@PostMapping("createCar")
	public Voiture createCar(@RequestBody Voiture utilisateur) {
		return this.voitureRepository.save(utilisateur);
	}
	
	@PutMapping("updateCar/{id}")
	public ResponseEntity<Voiture> updateCar(@PathVariable(name = "id")long id , @RequestBody Voiture carDetail) throws RessourceNotFoundException{
		Voiture car = voitureRepository.findById(id).orElseThrow( () -> new RessourceNotFoundException("Voiture "+ id + " pas trouver"));
		
		car.setMarque(carDetail.getMarque());
		car.setMatricule(carDetail.getMatricule());
		
		return ResponseEntity.ok(this.voitureRepository.save(car));
	}
	
	@DeleteMapping("deleteCar/{id}")
	public Map<String,Boolean> deleteCar(@PathVariable(name = "id")long id ) throws RessourceNotFoundException{
		Voiture car = voitureRepository.findById(id).orElseThrow( () -> new RessourceNotFoundException("Voiture "+ id + " pas trouver"));
		this.voitureRepository.delete(car);
		
		Map<String,Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		
		return response;
	}

}

package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.model.Utilisateur;
import com.example.demo.repository.UtitlisateurRepository;
import com.example.demo.service.UtilisateurService;

import net.bytebuddy.asm.Advice.Return;

@Controller
public class UtilisateurController {

	@Autowired
	private UtitlisateurRepository utitlisateurRepository;
	
	
	@Autowired
	private final UtilisateurService utilisateurService;
	
	public UtilisateurController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@GetMapping("/sign")
	public String getSignPage(Model model) {
		model.addAttribute("signRequest",new Utilisateur());
		return "sign_page.html";
	}
	
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("loginRequest",new Utilisateur());
		return "login_page.html";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute Utilisateur utilisateur , Model model) {
		System.out.println("register request = " +utilisateur);
		Utilisateur loginUtilisateur = utilisateurService.login(utilisateur.getNom(), utilisateur.getMpd());
		if (loginUtilisateur != null) {
			model.addAttribute("utilisateurLogin",loginUtilisateur.getNom());
			return "personal_page";
		}
		else {
			return "error_page";
		}
	}
	
	@PostMapping("/sign")
	public String sign(@ModelAttribute Utilisateur utilisateur) {
		System.out.println("register request = " +utilisateur);
		Utilisateur signUtilisateur = utilisateurService.registerUser(utilisateur.getNom(), utilisateur.getMpd());
		return signUtilisateur == null ? "error_page" : "redirect:/login";
	}
	
	
	
	@GetMapping("/getAllUser")
	public List<Utilisateur> getAllUser(){
		return this.utitlisateurRepository.findAll();
	}
	
	@GetMapping("/getAllUser/{id}")
	public ResponseEntity<Utilisateur> getAllUserById(@PathVariable(name = "id")long id) throws RessourceNotFoundException{
		Utilisateur utilisateur = utitlisateurRepository.findById(id)
		.orElseThrow( () -> new RessourceNotFoundException("Utilisateur "+ id + " pas trouver"));
		return ResponseEntity.ok().body(utilisateur);
	}
	
	@PostMapping("createUtilisateur")
	public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
		return this.utitlisateurRepository.save(utilisateur);
	}
	
	@PutMapping("updateUser/{id}")
	public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable(name = "id")long id , @RequestBody Utilisateur utilisateurDetail) throws RessourceNotFoundException{
		Utilisateur utilisateur = utitlisateurRepository.findById(id).orElseThrow( () -> new RessourceNotFoundException("Utilisateur "+ id + " pas trouver"));
		
		utilisateur.setNom(utilisateurDetail.getNom());
		utilisateur.setMpd(utilisateurDetail.getMpd());
		
		return ResponseEntity.ok(this.utitlisateurRepository.save(utilisateur));
	}
	
	@DeleteMapping("delete/{id}")
	public Map<String,Boolean> deleteUtilisateur(@PathVariable(name = "id")long id ) throws RessourceNotFoundException{
		Utilisateur utilisateur = utitlisateurRepository.findById(id).orElseThrow( () -> new RessourceNotFoundException("Utilisateur "+ id + " pas trouver"));
		this.utitlisateurRepository.delete(utilisateur);
		
		Map<String,Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		
		return response;
	}
	
}

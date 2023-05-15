package com.residencia.atividadeAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.atividadeAPI.entities.Telefone;
import com.residencia.atividadeAPI.repositories.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	TelefoneRepository telefoneRepository;
	
	public List <Telefone>getAllTelefonees() {
		
		return telefoneRepository.findAll();
	}
	
	public Telefone getTelefoneById(Long id) {
		
		return telefoneRepository.findById(id).orElse(null);	
	}
	
	public Telefone saveTelefone(Telefone telefone) {
		
		return telefoneRepository.save(telefone);
	}
	
	public Telefone updateTelefone(Telefone telefone, Long id) {
		
		return telefoneRepository.save(telefone);
	}	
	
	public Boolean deleteTelefone(Long id) {
		
		if(telefoneRepository.findById(id).orElse(null) != null) {
			telefoneRepository.deleteById(id);
			if(telefoneRepository.findById(id).orElse(null) == null)
				return true;
			else
				return false;
		}		
		else
			return false;
	}

}

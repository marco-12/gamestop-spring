package it.dstech.formazione.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.formazione.model.Videogioco;
import it.dstech.formazione.repository.VideogiocoRepository;

@Service
@Transactional
public class VideogiocoService {
	
	@Autowired VideogiocoRepository repo;

	public void save(Videogioco videogioco) {
		repo.save(videogioco);
	}
	
	public List<Videogioco> listAll() {
		return (List<Videogioco>) repo.findAll();
	}
	
	public Videogioco get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Videogioco> search(String keyword) {
		return repo.search(keyword);
	}
	
	public List<Videogioco> orderByPrezzo() {
		return repo.orderByPrezzo();
	}
	
	public List<Videogioco> orderByNome() {
		return repo.orderByNome();
	}
	
	public List<Videogioco> orderByCategoria() {
		return repo.orderByCategoria();
	}
	
	public List<Videogioco> orderByClassificazione() {
		return repo.orderByClassificazione();
	}
	
}

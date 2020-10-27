package com.leoneider.apivideojuegos.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leoneider.apivideojuegos.modelo.Juego;
import com.leoneider.apivideojuegos.negocio.repository.JuegoRepository;

@Service
@Transactional(readOnly = true)
public class JuegoService {
	
	private final JuegoRepository juegoRepository;

	public JuegoService(JuegoRepository juegoRepository) {
		this.juegoRepository = juegoRepository;
	}
	
	
	public List<Juego> findAll() {
		return this.juegoRepository.findAll();
	}
	
	
	public List<Juego> findByNombre(String nombre) {
		return this.juegoRepository.findByNombre(nombre);
	}
	
	
	
	
	public List<Juego> buscarPorNombre(String nombre) {
		return this.juegoRepository.buscarPorNombre(nombre);
	}
	
	public Juego findById(long id) {
		return this.juegoRepository.findById(id);
	}
	

}

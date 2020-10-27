/**
 * 
 */
package com.leoneider.apivideojuegos.negocio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leoneider.apivideojuegos.modelo.Alquiler;
import com.leoneider.apivideojuegos.negocio.repository.AlquilerRepository;


/**
 * @author leoneider42
 *
 */
@Service
@Transactional(readOnly = true)
public class AlquilerService {
	
	@Autowired
	private AlquilerRepository alquilerRepository;

	
	/**
	 * save client
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Alquiler create(Alquiler alquiler) {
		return this.alquilerRepository.save(alquiler);
	}
	
	public long masFrecuente() {
		return this.alquilerRepository.masFrecuente();
	}
	
	public long gameMasFrecuente() {
		return this.alquilerRepository.gameMasFrecuente();
	}
	
	
	
	
	
	
	

}

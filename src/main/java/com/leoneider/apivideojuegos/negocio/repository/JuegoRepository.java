/**
 * 
 */
package com.leoneider.apivideojuegos.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leoneider.apivideojuegos.modelo.Juego;

/**
 * @author leoneider42
 *
 */
public interface JuegoRepository extends JpaRepository<Juego, Integer>{
	
	public Juego findById(long id);
	
	public List<Juego> findByNombre(String nombre);
	
	
	@Query("SELECT j FROM Juego j WHERE j.nombre LIKE %:nombre% order by j.nombre")
	public List<Juego> buscarPorNombre(String nombre);
	
	
//	public List<Juego> findByNombreLike(String nombre);

}

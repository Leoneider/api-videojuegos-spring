/**
 * 
 */
package com.leoneider.apivideojuegos.negocio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.leoneider.apivideojuegos.modelo.Alquiler;



/**
 * @author leoneider42
 *
 */
public interface AlquilerRepository extends JpaRepository<Alquiler, Integer>{
	
	@Query("Select a from Alquiler a where a.fechaAlquiler =: fechaInicio and a.fechaEntrega=: fechaActual")
	public List<Alquiler>find(@Param("fechaInicio") Date fechaInicio, @Param("fechaActual") Date fechaActaul);
	
	
	@Query(value="SELECT id_cliente FROM alquileres A\n"
			+ "INNER JOIN clientes C ON C.id = A.id_cliente\n"
			+ "GROUP BY id_cliente\n"
			+ "ORDER BY COUNT(id_cliente) DESC\n"
			+ "LIMIT 1;", nativeQuery = true)
	public long masFrecuente();
	
	
	@Query(value="SELECT id_juego FROM alquileres A\n"
			+ "INNER JOIN juegos C ON C.id = A.id_juego\n"
			+ "GROUP BY id_juego\n"
			+ "ORDER BY COUNT(id_juego) DESC\n"
			+ "LIMIT 1;", nativeQuery = true)
	public long gameMasFrecuente();
	
	
	
	

}



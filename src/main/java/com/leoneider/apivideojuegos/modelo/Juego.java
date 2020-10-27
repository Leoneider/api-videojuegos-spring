/**
 * 
 */
package com.leoneider.apivideojuegos.modelo;



import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author leoneider42
 *
 */
@Data
@Entity
@Table(name = "juegos")
public class Juego {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombre;
	private String director;
	private String protagonista;
	private String productor;
	private String marca;
	@Temporal(TemporalType.DATE)
	private Date anio;
	private int precio;
	
	
	@OneToMany(mappedBy = "juego")
	@JsonIgnore
	private Set<Alquiler> alquileres;
	
	public Juego() {
		// TODO AUTO GENERADO CONSTRUCTOR
	}
	

}

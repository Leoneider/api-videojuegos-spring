package com.leoneider.apivideojuegos.modelo;

import java.util.Date;

//import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Esta clase representa los alquileres
 * @author leoneider42
 *
 */
@Data
@Entity
@Table(name = "alquileres")
public class Alquiler {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date fechaAlquiler;
	
	@Temporal(TemporalType.DATE)
	private Date fechaEntrega;
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	@JsonIgnore
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="idJuego")
	@JsonIgnore
	private Juego juego;
	
}

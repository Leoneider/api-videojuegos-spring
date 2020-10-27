package com.leoneider.apivideojuegos.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Esta clase representa la tabla Cliente
 * @author leoneider42
 *
 */

@Data
@Entity
@Table(name = "clientes")
@NamedQuery(name="Cliente.findByTelefono", query = "Select c from Cliente c where c.telefono = ?1")
public class Cliente {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String documento;
	private String nombre;
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	private String telefono;
	
	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	private Set<Alquiler> alquileres;
	
	public Cliente() {
		// TODO AUTO GENERADO CONSTRUCTOR
	}
	
}
;
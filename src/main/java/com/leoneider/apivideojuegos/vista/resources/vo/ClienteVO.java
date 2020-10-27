package com.leoneider.apivideojuegos.vista.resources.vo;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * Esta clase representa la tabla Cliente
 * 
 * @author leoneider42
 *
 */

@Data
public class ClienteVO {
	
	private String documento;
	private String nombre;
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	private String telefono;

}

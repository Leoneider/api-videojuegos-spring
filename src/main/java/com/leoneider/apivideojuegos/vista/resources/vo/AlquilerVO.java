/**
 * 
 */
package com.leoneider.apivideojuegos.vista.resources.vo;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import lombok.Data;



/**
 * @author leoneider42
 *
 */
@Data
public class AlquilerVO {
	
	
	private long cliente;
	private long videojuego;
	@Temporal(TemporalType.DATE)
	private Date fechaAlquiler;
	@Temporal(TemporalType.DATE)
	private Date fechaEntrega;
	

}

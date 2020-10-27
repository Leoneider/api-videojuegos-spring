/**
 * 
 */
package com.leoneider.apivideojuegos.negocio.services;



import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leoneider.apivideojuegos.modelo.Cliente;
import com.leoneider.apivideojuegos.negocio.repository.ClienteRepository;

/**
 * Clase para definir los servicios del cliente
 * 
 * @author leoneider42
 *
 */

@Service
@Transactional(readOnly = true)
public class ClienteService {
	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	
	/**
	 * save client
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	
	/**
	 * update client
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	/**
	 * Delete client
	 * @param cliente
	 */
	@Transactional
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}
	
	/**
	 * Consultar cliente por identificacion
	 * @param documento
	 * @return
	 */
	
	public Cliente findByDocumento(String documento) {
		return this.clienteRepository.findByDocumento(documento);
	}
	
	public Cliente findById(long id) {
		return this.clienteRepository.findById(id);
	}
	
	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}
	
	
	
//	
//	public List<Cuota> liquidar( Solicitud prestamo ){
//		double tasa = solicitudRepository.findlinea(prestamo.linea);
//		
//		
//		valorCuota = 
//		
//		
//	}
	
	

}

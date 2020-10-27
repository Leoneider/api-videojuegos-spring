/**
 * 
 */
package com.leoneider.apivideojuegos.negocio.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;



import com.leoneider.apivideojuegos.modelo.Cliente;

/**
 * Interfas para definir las operaciones de datos relacionadas con el Cliente
 * @author leoneider42
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	
	public Cliente findById(long id);
	


	/**
	 * Buscar cliente por documento
	 * @param documento
	 * @return
	 */
	
	public Cliente findByDocumento(String documento);
	
	/**
	 * Consultar clientes por nombre
	 * @param nombre
	 * @return
	 */
	
	public List<Cliente> findByNombre(String nombre);
	
	/**
	 * Consultar cliente por numero de telefono
	 * @param telefono
	 * @return
	 */
	
	public Cliente findByTelefono(String telefono);
	

	
	
 
}

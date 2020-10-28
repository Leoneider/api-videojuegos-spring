/**
 * 
 */
package com.leoneider.apivideojuegos.vista.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leoneider.apivideojuegos.modelo.Cliente;
import com.leoneider.apivideojuegos.negocio.services.ClienteService;
import com.leoneider.apivideojuegos.vista.resources.vo.ClienteVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el servicio web de cliente
 * 
 * @author leoneider42
 *
 */

@CrossOrigin("http://localhost:8100")
@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	

	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para crear un nuevo cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })

	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVo) {
		Cliente cliente = new Cliente();
		cliente.setDocumento(clienteVo.getDocumento());
		cliente.setNombre(clienteVo.getNombre());
		cliente.setFechaNacimiento(clienteVo.getFechaNacimiento());
		cliente.setTelefono(clienteVo.getTelefono());
		return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/{identificacion}")
	@ApiOperation(value = "Actualizar Cliente", notes = "Servicio para actualiza cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	
	public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacion") long identificacion,
			ClienteVO clienteVo) {

		Cliente cliente = this.clienteService.findById(identificacion);

		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);

		} else {

			cliente.setDocumento(clienteVo.getDocumento());
			cliente.setNombre(clienteVo.getNombre());
			cliente.setFechaNacimiento(clienteVo.getFechaNacimiento());
			cliente.setTelefono(clienteVo.getTelefono());
			return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{identificacion}")
	@ApiOperation(value = "Eliminar Cliente", notes = "Cliente eliminado")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	
	public void removeCliente(@PathVariable("identificacion") long identificacion, ClienteVO clienteVo) {

		Cliente cliente = this.clienteService.findById(identificacion);

		if (cliente != null) {
			this.clienteService.delete(cliente);

		}
	}

	@GetMapping
	@ApiOperation(value = "Clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes listados correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })

	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok(this.clienteService.findAll());
	}
	
	@GetMapping("/buscar")
	@ApiOperation(value = "Clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes listados correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Cliente> findByDocumento(@RequestParam(name="documento", required=true) String documento) {
		return ResponseEntity.ok(this.clienteService.findByDocumento(documento));
	}
	
	
	
	


}

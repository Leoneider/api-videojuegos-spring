/**
 * 
 */
package com.leoneider.apivideojuegos.vista.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leoneider.apivideojuegos.modelo.Alquiler;
import com.leoneider.apivideojuegos.modelo.Cliente;
import com.leoneider.apivideojuegos.modelo.Juego;
import com.leoneider.apivideojuegos.negocio.services.AlquilerService;
import com.leoneider.apivideojuegos.negocio.services.ClienteService;
import com.leoneider.apivideojuegos.negocio.services.JuegoService;
import com.leoneider.apivideojuegos.vista.resources.vo.AlquilerVO;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author leoneider42
 *
 */
@CrossOrigin("http://localhost:8100")
@RestController
@RequestMapping("/api/alquiler")
@Api(tags = "alquiler")
public class AlquilerResource {
	private static Logger LOG = LoggerFactory.getLogger(ClienteResource.class);
	
	@Autowired
	private AlquilerService alquilerService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private JuegoService juegoService;
	
	
	
	
	@PostMapping
	@ApiOperation(value = "Crear Alquiler", notes = "Servicio para crear un nuevo Alquiler")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Alquiler creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })

	public ResponseEntity<Alquiler> createAlquiler(@RequestBody AlquilerVO alquilerVO) {
		

	
		Alquiler alquiler = new Alquiler();
		Cliente cliente = new Cliente();
		Juego juego = new Juego();
		
	
		
		cliente = this.clienteService.findById(alquilerVO.getCliente());
		juego = this.juegoService.findById(alquilerVO.getVideojuego());
		
		LOG.info("cliente" + alquilerVO.getCliente());
		LOG.info("juego" + alquilerVO.getVideojuego());
		
		
		alquiler.setCliente(cliente);
		alquiler.setJuego(juego);
		alquiler.setFechaAlquiler(alquilerVO.getFechaAlquiler());
		alquiler.setFechaEntrega(alquilerVO.getFechaEntrega());
		
		return new ResponseEntity<>(this.alquilerService.create(alquiler), HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/climax")
	@ApiOperation(value = "Clientes", notes = "Servicio para listar cliente mas recurrente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente consultado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Cliente> masFrecuente() {
		Cliente cliente = new Cliente();
		long id = this.alquilerService.masFrecuente();
		cliente = this.clienteService.findById(id);
		
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping("/gamemax")
	@ApiOperation(value = "Juegos", notes = "Juego mas alquilado")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Juego consultado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Juego> gameMasFrecuente() {
		Juego juego = new Juego();
		long id = this.alquilerService.gameMasFrecuente();
		juego = this.juegoService.findById(id);
		
		return ResponseEntity.ok(juego);
	}

}

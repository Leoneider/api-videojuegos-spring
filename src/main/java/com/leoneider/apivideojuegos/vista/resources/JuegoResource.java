/**
 * 
 */
package com.leoneider.apivideojuegos.vista.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.leoneider.apivideojuegos.modelo.Juego;

import com.leoneider.apivideojuegos.negocio.services.JuegoService;

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
@RequestMapping("/api/juego")
@Api(tags = "juego")
public class JuegoResource {
	
	private static Logger LOG = LoggerFactory.getLogger(ClienteResource.class);
	
	
	@Autowired
	private JuegoService juegoService;


	@GetMapping
	@ApiOperation(value = "Juegos", notes = "Servicio para listar todos los juegos")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Juegos listados correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })

	public ResponseEntity<List<Juego>> findAll() {
		return ResponseEntity.ok(this.juegoService.findAll());
	}
	
	
	@GetMapping("/buscar")
	@ApiOperation(value = "Juegos", notes = "Consulta juegos por nombre")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Juegos listados correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })

	public ResponseEntity<List<Juego>> buscarPorNombre(@RequestParam(name="name", required=false, defaultValue="Fornite") String nombre) {
		nombre = nombre.toLowerCase();
		LOG.info("Este es el " + nombre);
		return ResponseEntity.ok(this.juegoService.buscarPorNombre(nombre));
	}
	

	@GetMapping("/{id}")
	@ApiOperation(value = "Juegos", notes = "Consulta juegos por nombre")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Juegos listados correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })

	public ResponseEntity<Juego> buscarPorId(@PathVariable("id") long id) {
		return ResponseEntity.ok(this.juegoService.findById(id));
	}
	
	
}

package com.codingdojo.ezequiel.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.ezequiel.modelos.Usuario;
import com.codingdojo.ezequiel.servicios.Servicio;

@RestController
@RequestMapping("/api/usuarios")
public class ControladorAPI {
	
	@Autowired
	private Servicio servicio;
	
	@GetMapping("/")
	public List<Usuario> apiMuestraUsuarios() {
		return servicio.todosUsuarios();
	}

	@PostMapping("/")
	public Usuario apiCrearUsuario(@RequestParam ("nombre") String nombre,
								   @RequestParam("apellido") String apellido,
								   @RequestParam("email") String email,
								   @RequestParam("password") String password) {
		Usuario nuevoUsuario = new Usuario(nombre, apellido, email, password);
		return servicio.guardarUsuario(nuevoUsuario);
	}
	@DeleteMapping("/{id}")
	public void apiEliminarUsuario(@PathVariable("id") Long id) {
		servicio.borrarUsuario(id);
	}
	
	@GetMapping("/{id}")
	public Usuario apiMostrarUsuario(@PathVariable("id") Long id) {
		return servicio.buscarUsuario(id);
	}
	
	@PutMapping("/{id}")
	public Usuario apiEditarUsuario(@PathVariable("id") Long id,
									@RequestParam ("nombre") String nombre,
								    @RequestParam("apellido") String apellido,
								    @RequestParam("email") String email,
								    @RequestParam("password") String password) {
		Usuario usuarioActualizado = new Usuario(id, nombre, apellido, email, password);
		return servicio.guardarUsuario(usuarioActualizado);
	}
}

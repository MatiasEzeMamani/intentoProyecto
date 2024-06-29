package com.codingdojo.ezequiel.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.ezequiel.modelos.Hobby;
import com.codingdojo.ezequiel.modelos.Usuario;
import com.codingdojo.ezequiel.servicios.Servicio;

@Controller
public class ControladorHobbies {
	@Autowired 
	private Servicio servicio;
	
	@GetMapping("/asignar/{id}")
	public String asignar(@PathVariable("id") Long id,
						  Model model) {
		Usuario miUsuario = servicio.buscarUsuario(id);
		model.addAttribute("usuario", miUsuario);
		List<Hobby> hobbies = servicio.todosHobby();
		model.addAttribute("hobbies", hobbies);
		return "asignar.jsp";
	}	
	@GetMapping("/asignarHobby/{usuarioId}/{hobbyId}")
	public String asignaHobby(@PathVariable("usuarioId") Long usuarioId,
							  @PathVariable("hobbyId") Long hobbyId) {
		servicio.guardarUsuarioHobby(usuarioId, hobbyId);
		return "redirect:/asignar/{usuarioId}";
	}
	
	@GetMapping("/quitarHobby/{usuarioId}/{hobbyId}")
	public String quitarHobby(@PathVariable("usuarioId") Long usuarioId,
							  @PathVariable("hobbyId") Long hobbyId) {
		servicio.quitarUsuarioHobby(usuarioId, hobbyId);
		return "redirect:/asignar/{usuarioId}";
	}
}

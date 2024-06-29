package com.codingdojo.ezequiel.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.ezequiel.modelos.Hobby;
import com.codingdojo.ezequiel.modelos.Salon;
import com.codingdojo.ezequiel.modelos.Usuario;
import com.codingdojo.ezequiel.repositorios.RepositorioHobbies;
import com.codingdojo.ezequiel.repositorios.RepositorioSalones;
import com.codingdojo.ezequiel.repositorios.RepositorioUsuarios;

@Service
public class Servicio {
	
	@Autowired
	private RepositorioUsuarios ru;
	
	@Autowired
	private RepositorioHobbies rh;
	
	@Autowired
	private RepositorioSalones rs;
	
	public List<Salon> todosSalones(){
		return rs.findAll();
	}	
	
	//Metodo que me regrese todos los usuarios
	public List<Usuario> todosUsuarios(){
		return ru.findAll(); 
	}
	
	//Metodo que guarde usuarios(nuevo registros como actualizaciones)
	public Usuario guardarUsuario(Usuario nuevoUsuario) {
		return ru.save(nuevoUsuario);
	}
	
	public Usuario buscarUsuario(Long id) {
		return ru.findById(id).orElse(null);
	}
	
	public void borrarUsuario(Long id) {
		ru.deleteById(id);
	}
	
	public List<Hobby> todosHobby(){
		return rh.findAll();
	}
	
	public Hobby buscarHobby(Long id){
		return rh.findById(id).orElse(null);
	}
	
	public void guardarUsuarioHobby(Long usuarioId, Long hobbyId) {
		Usuario miUsuario = buscarUsuario(usuarioId);
		Hobby miHobby = buscarHobby(hobbyId);
		miUsuario.getHobbies().add(miHobby);
		ru.save(miUsuario);
	}
	
	public void quitarUsuarioHobby(Long usuarioId, Long hobbyId) {
		Usuario miUsuario = buscarUsuario(usuarioId);
		Hobby miHobby = buscarHobby(hobbyId);
		miUsuario.getHobbies().remove(miHobby);
		ru.save(miUsuario);
	}
}







































	
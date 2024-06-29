package com.codingdojo.ezequiel.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ezequiel.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {

	List<Usuario> findAll(); //SELECT * FROM usuarios;
	
	//Si tiene id es un update, si no tiene es un create 
	//INSERT INTO usuarios(nombre, apellido, ...) VALUES (Atributso del objeto usuario)
	//UPDATE usuarios SET nombre = Valor de objeto...
	Usuario save(Usuario nuevoUsuario);
	
	//CrudRepository: findAll(), findById(id), save(Object obj), deleteById(id)4   
	
	
	//SELECT * FROM usuarios WHERE email = <email que recibimos en metodo>
	List<Usuario> findByEmail(String email);
	
	//SELECT * FROM usuarios WHERE email = <nombre que recibimos en metodo>
	List<Usuario> findByNombre(String nombre);
	
	//SELECT * FROM usurios WHERE nombre LIkE "<lestras>%"
	List<Usuario> findByNombreStartingWith(String letras);
	
	List<Usuario> findByNombreContaining(String letras);
	
	
}

package com.codingdojo.ezequiel.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ezequiel.modelos.Hobby;

@Repository
public interface RepositorioHobbies extends CrudRepository <Hobby, Long> {
	List<Hobby> findAll(); 
}

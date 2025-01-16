package com.ista.demo.Dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ista.demo.Entity.Usuario;



@Repository
public interface UsuarioDai extends CrudRepository<Usuario, Long>{
	

}

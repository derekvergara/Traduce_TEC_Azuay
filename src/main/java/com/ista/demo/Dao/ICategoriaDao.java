package com.ista.demo.Dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.demo.Entity.Categoria;

public interface ICategoriaDao extends CrudRepository<Categoria, Long>{

}

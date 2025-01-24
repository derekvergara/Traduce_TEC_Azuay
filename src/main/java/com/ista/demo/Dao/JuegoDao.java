package com.ista.demo.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ista.demo.Entity.Juego;

@Repository
public interface JuegoDao extends CrudRepository<Juego, Long>{

}

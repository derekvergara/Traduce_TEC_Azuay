package com.ista.demo.Dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.demo.Entity.Aprendizaje;


public interface IAprendizajeDao extends CrudRepository<Aprendizaje, Long> {

}

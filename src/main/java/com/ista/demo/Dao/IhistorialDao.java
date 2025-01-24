package com.ista.demo.Dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.demo.Entity.Historial_traduccion;
import com.ista.demo.Entity.Nivel;

public interface IhistorialDao extends CrudRepository<Historial_traduccion, Long> {

}

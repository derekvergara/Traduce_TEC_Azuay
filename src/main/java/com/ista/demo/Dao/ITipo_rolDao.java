package com.ista.demo.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ista.demo.Entity.Tipo_rol;

@Repository
public interface ITipo_rolDao extends CrudRepository<Tipo_rol, Long>{

}

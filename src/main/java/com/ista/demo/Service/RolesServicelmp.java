package com.ista.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.demo.Dao.IRolesDao;
import com.ista.demo.Entity.Roles;

@Service
public class RolesServicelmp implements IRolesService{

	
	@Autowired
	private IRolesDao rolesDao;

	@Override
	@Transactional(readOnly = true )
	public List<Roles> findAll() {
		// TODO Auto-generated method stub
		return (List<Roles>)rolesDao.findAll();
	}

	@Override
	@Transactional(readOnly = true )
	public Roles findById(Long id) {
		// TODO Auto-generated method stub
		return rolesDao.findById(id).orElse(null);
	}

	@Override
	public Roles save(Roles roles) {
		// TODO Auto-generated method stub
		return rolesDao.save(roles);
	}

	@Override
	public void delete(Long id) {

		rolesDao.deleteById(id);		
	}

}

package com.techedgegroup.musicshop.DAO;

import org.springframework.data.repository.CrudRepository;

import com.techedgegroup.musicshop.DAOCustom.TechUserDAOCustom;
import com.techedgegroup.musicshop.entities.TechUser;

public interface TechUserDAO extends CrudRepository<TechUser, Integer>, TechUserDAOCustom
{
	
	TechUser findById(Integer id); 

}

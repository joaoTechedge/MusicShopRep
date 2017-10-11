package com.techedgegroup.musicshop.DAO;

import org.springframework.data.repository.CrudRepository;

import com.techedgegroup.musicshop.DAOCustom.VersionControllerDAOCustom;
import com.techedgegroup.musicshop.entities.VersionController;

public interface VersionControllerDAO extends CrudRepository<VersionController, Integer>, VersionControllerDAOCustom{
	
	VersionController findById(Integer id); 

}

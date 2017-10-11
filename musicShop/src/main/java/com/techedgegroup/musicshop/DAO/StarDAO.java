package com.techedgegroup.musicshop.DAO;

import org.springframework.data.repository.CrudRepository;

import com.techedgegroup.musicshop.DAOCustom.StarDAOCustom;
import com.techedgegroup.musicshop.entities.Star;

public interface StarDAO extends CrudRepository<Star, Integer>, StarDAOCustom{
	
	Star findById(Integer id); 

}

package com.techedgegroup.musicshop.DAO;

import org.springframework.data.repository.CrudRepository;

import com.techedgegroup.musicshop.DAOCustom.MusicStarDAOCustom;
import com.techedgegroup.musicshop.entities.MusicStar;

public interface MusicStarDAO extends CrudRepository<MusicStar, Integer>, MusicStarDAOCustom{
	
	MusicStar findById(Integer id); 

}

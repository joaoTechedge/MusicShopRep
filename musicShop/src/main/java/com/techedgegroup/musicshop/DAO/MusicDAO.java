package com.techedgegroup.musicshop.DAO;

import org.springframework.data.repository.CrudRepository;

import com.techedgegroup.musicshop.DAOCustom.MusicDAOCustom;
import com.techedgegroup.musicshop.entities.Music;

public interface MusicDAO extends CrudRepository<Music, Integer>, MusicDAOCustom{
	
	Music findById(Integer id); 

}

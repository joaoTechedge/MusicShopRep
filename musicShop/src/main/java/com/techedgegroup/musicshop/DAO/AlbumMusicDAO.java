package com.techedgegroup.musicshop.DAO;

import org.springframework.data.repository.CrudRepository;

import com.techedgegroup.musicshop.DAOCustom.AlbumMusicDAOCustom;
import com.techedgegroup.musicshop.entities.AlbumMusic;

public interface AlbumMusicDAO extends CrudRepository<AlbumMusic, Integer>, AlbumMusicDAOCustom{
	
	AlbumMusic findById(Integer id); 

}

package com.techedgegroup.musicshop.DAO;

import org.springframework.data.repository.CrudRepository;

import com.techedgegroup.musicshop.DAOCustom.ShopAlbumDAOCustom;
import com.techedgegroup.musicshop.entities.ShopAlbum;

public interface ShopAlbumDAO extends CrudRepository<ShopAlbum, Integer>, ShopAlbumDAOCustom{
	
	ShopAlbum findById(Integer id); 

}

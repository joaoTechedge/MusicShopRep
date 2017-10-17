package com.techedgegroup.musicshop.DAO;

import org.springframework.data.repository.CrudRepository;

import com.techedgegroup.musicshop.DAOCustom.AlbumBasketDAOCustom;
import com.techedgegroup.musicshop.entities.AlbumBasket;

public interface AlbumBasketDAO extends CrudRepository<AlbumBasket, Integer>, AlbumBasketDAOCustom{
	
	AlbumBasket findById(Integer id); 

}

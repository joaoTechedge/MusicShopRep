package com.techedgegroup.musicshop.DAO;

import org.springframework.data.repository.CrudRepository;

import com.techedgegroup.musicshop.DAOCustom.ShopDAOCustom;
import com.techedgegroup.musicshop.entities.Shop;

public interface ShopDAO extends CrudRepository<Shop, Integer>, ShopDAOCustom{
	
	Shop findById(Integer id); 

}

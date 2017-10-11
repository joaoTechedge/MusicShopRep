package com.techedgegroup.musicshop.DAO;

import org.springframework.data.repository.CrudRepository;

import com.techedgegroup.musicshop.DAOCustom.BasketDAOCustom;
import com.techedgegroup.musicshop.entities.Basket;

public interface BasketDAO extends CrudRepository<Basket, Integer>, BasketDAOCustom{
	
	Basket findById(Integer id); 

}

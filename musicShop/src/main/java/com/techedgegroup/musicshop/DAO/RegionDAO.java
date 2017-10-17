package com.techedgegroup.musicshop.DAO;

import org.springframework.data.repository.CrudRepository;

import com.techedgegroup.musicshop.DAOCustom.RegionDAOCustom;
import com.techedgegroup.musicshop.entities.Region;

public interface RegionDAO extends CrudRepository<Region, Integer>, RegionDAOCustom{
	
	Region findById(Integer id); 

}

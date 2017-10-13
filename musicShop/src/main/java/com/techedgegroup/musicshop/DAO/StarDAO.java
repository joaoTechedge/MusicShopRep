package com.techedgegroup.musicshop.DAO;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.techedgegroup.musicshop.DAOCustom.StarDAOCustom;
import com.techedgegroup.musicshop.entities.Star;

public interface StarDAO extends CrudRepository<Star, Integer>, StarDAOCustom{
	
Star findById(Integer idStar);
	
	@Query("select s from Star s where (s.name_star like :searchText or s.name_star_professional like :searchText or s.gender like :searchText)")
	List<Star> getStarFiltered(@Param("searchText")String searchText, Sort sort);

}

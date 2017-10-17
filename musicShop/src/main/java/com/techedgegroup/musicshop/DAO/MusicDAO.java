package com.techedgegroup.musicshop.DAO;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.techedgegroup.musicshop.DAOCustom.MusicDAOCustom;
import com.techedgegroup.musicshop.entities.Music;


public interface MusicDAO extends CrudRepository<Music, Integer>, MusicDAOCustom{
	
	Music findById(Integer idMusic);
	
	@Query("select m from Music m where (m.name_music like :searchText or m.style_music like :searchText or m.publisher like :searchText or m.duraction like :searchText or m.year like :searchText)")
	List<Music> getMusicFiltered(@Param("searchText")String searchText, Sort sort);
}
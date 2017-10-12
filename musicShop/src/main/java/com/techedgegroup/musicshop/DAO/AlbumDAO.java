package com.techedgegroup.musicshop.DAO;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.techedgegroup.musicshop.DAOCustom.AlbumDAOCustom;
import com.techedgegroup.musicshop.entities.Album;

public interface AlbumDAO extends CrudRepository<Album, Integer>, AlbumDAOCustom{
	
	Album findById(Integer idAlbum);
	
	@Query("select a from Album a where (a.name_album like :searchText or a.style like :searchText or a.publisher like :searchText or a.year like :searchText)")
	List<Album> getAlbumsFiltered(@Param("searchText")String searchText, Sort sort);
}

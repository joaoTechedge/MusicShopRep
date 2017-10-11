package com.techedgegroup.musicshop.DAO;


import org.springframework.data.repository.CrudRepository;

import com.techedgegroup.musicshop.DAOCustom.AlbumDAOCustom;
import com.techedgegroup.musicshop.entities.Album;

public interface AlbumDAO extends CrudRepository<Album, Integer>, AlbumDAOCustom{
	
	Album findById(Integer idAlbum);
}

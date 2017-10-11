package com.techedgegroup.musicshop.facades.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techedgegroup.musicshop.DAO.AlbumDAO;
import com.techedgegroup.musicshop.DTO.AlbumDTO;
import com.techedgegroup.musicshop.entities.Album;
import com.techedgegroup.musicshop.facades.AlbumFacade;

@Service
public class AlbumFacadeImpl implements AlbumFacade {

	@Autowired
	private AlbumDAO albumDAO;

	@Override
	public List<AlbumDTO> getAlbumList() {
		List<Album> albumEntitys = (List<Album>) albumDAO.findAll();
		List<AlbumDTO> dto = new ArrayList<>();
		for(Album alb : albumEntitys) {
			AlbumDTO temp = new AlbumDTO().convertFromEntity(alb);
			dto.add(temp);
		}
		return dto;
	}


}

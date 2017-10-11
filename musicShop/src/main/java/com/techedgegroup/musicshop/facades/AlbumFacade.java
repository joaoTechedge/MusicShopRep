package com.techedgegroup.musicshop.facades;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techedgegroup.musicshop.DTO.AlbumDTO;

@Service
public interface AlbumFacade {
	
	public List<AlbumDTO> getAlbumList();

}

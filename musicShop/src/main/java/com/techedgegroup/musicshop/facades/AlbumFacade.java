package com.techedgegroup.musicshop.facades;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techedgegroup.musicshop.DTO.AlbumCriteriaDTO;
import com.techedgegroup.musicshop.DTO.AlbumDTO;

@Service
public interface AlbumFacade {
	
	public List<AlbumDTO> getAlbumList() throws Exception;

	public List<AlbumDTO> getAlbumListFiltered(AlbumCriteriaDTO dto) throws Exception;
	
	public String createAlbum(AlbumDTO albumDTO) throws Exception;

	public String updateAlbum(AlbumDTO albumDTO) throws Exception;
	
	public String deleteAlbum(int id) throws Exception;
}

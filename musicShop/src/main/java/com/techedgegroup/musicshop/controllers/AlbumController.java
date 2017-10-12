package com.techedgegroup.musicshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techedgegroup.musicshop.DTO.AlbumCriteriaDTO;
import com.techedgegroup.musicshop.DTO.AlbumDTO;
import com.techedgegroup.musicshop.facades.AlbumFacade;


@RestController
@RequestMapping("/rest/album")
public class AlbumController {

	@Autowired
	AlbumFacade albumFacade;
	
	@RequestMapping(value="/getAlbuns",  method=RequestMethod.GET)	
	public List<AlbumDTO> listaAlbum(){
		return albumFacade.getAlbumList();
		
	}
	
	@RequestMapping(value="/getAlbunsFiltered",  method=RequestMethod.POST)	
	public List<AlbumDTO> listaAlbumFiltered( @RequestBody AlbumCriteriaDTO dto){
		
		
		return albumFacade.getAlbumListFiltered(dto);
		
	}
		
}

package com.techedgegroup.musicshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techedgegroup.musicshop.DTO.MusicCriteriaDTO;
import com.techedgegroup.musicshop.DTO.MusicDTO;
import com.techedgegroup.musicshop.facades.MusicFacade;


@RestController
@RequestMapping("/rest/music")
public class MusicController {

	@Autowired
	MusicFacade musicFacade;
	
	@RequestMapping(value="/getMusic",  method=RequestMethod.GET)	
	public List<MusicDTO> listaMusic(){
		return musicFacade.getMusicList();
		
	}
	
	@RequestMapping(value="/getMusicFiltered",  method=RequestMethod.POST)	
	public List<MusicDTO> listaMusicFiltered( @RequestBody MusicCriteriaDTO dto){
		
		
		return musicFacade.getMusicListFiltered(dto);
		
	}
		
}

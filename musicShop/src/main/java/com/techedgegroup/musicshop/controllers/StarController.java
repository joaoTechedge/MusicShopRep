package com.techedgegroup.musicshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techedgegroup.musicshop.DTO.StarCriteriaDTO;
import com.techedgegroup.musicshop.DTO.StarDTO;
import com.techedgegroup.musicshop.facades.StarFacade;


@RestController
@RequestMapping("/rest/star")
public class StarController {

	@Autowired
	StarFacade starFacade;
	
	@RequestMapping(value="/getStar",  method=RequestMethod.GET)	
	public List<StarDTO> listaStar(){
		return starFacade.getStarList();
		
	}
	
	@RequestMapping(value="/getStarFiltered",  method=RequestMethod.POST)	
	public List<StarDTO> listaStarFiltered( @RequestBody StarCriteriaDTO dto){
		
		
		return starFacade.getStarListFiltered(dto);
		
	}
		
}

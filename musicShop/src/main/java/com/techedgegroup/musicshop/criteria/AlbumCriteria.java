package com.techedgegroup.musicshop.criteria;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techedgegroup.musicshop.DTO.AlbumDTO;

public class AlbumCriteria implements Serializable{
	
	private static final long serialVersionUID = -2254283481752163428L;

	@RequestMapping(value="/getAlbunsOrdered",  method=RequestMethod.POST)	
	public List<AlbumDTO> listaAlbumOrdered(@RequestBody String fieldToOrder){
		return null;
		
	}
	

}

package com.techedgegroup.musicshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<AlbumDTO>> listaAlbum() throws Exception{
		
		ResponseEntity<List<AlbumDTO>> result = new ResponseEntity<>(albumFacade.getAlbumList(), HttpStatus.OK) ;
		return result;
	}

	@RequestMapping(value="/getAlbunsFiltered",  method=RequestMethod.POST)	
	public ResponseEntity<List<AlbumDTO>>  listaAlbumFiltered(@RequestBody AlbumCriteriaDTO dto) throws Exception{
		
		ResponseEntity<List<AlbumDTO>> result = new ResponseEntity<>(albumFacade.getAlbumListFiltered(dto), HttpStatus.OK) ;
		return result;
	}

	@RequestMapping(value="/createAlbum",  method=RequestMethod.POST, produces="text/plain")
	public ResponseEntity<String> createAlbum(@RequestBody AlbumDTO albumDTO) throws Exception{
		
		ResponseEntity<String> result = new ResponseEntity<>(albumFacade.createAlbum(albumDTO), HttpStatus.OK);
		return result;
	}

	@RequestMapping(value="/updateAlbum",  method=RequestMethod.POST, produces="text/plain")
	public ResponseEntity<String> updateAlbum(@RequestBody AlbumDTO albumDTO) throws Exception {

		ResponseEntity<String> result = new ResponseEntity<>(albumFacade.updateAlbum(albumDTO), HttpStatus.OK);
		return result;
	}

	@RequestMapping(value="/deleteAlbum",  method=RequestMethod.POST, produces="text/plain")
	public ResponseEntity<String> deleteAlbum(@RequestBody int id) throws Exception{
		
		ResponseEntity<String> result = new ResponseEntity<>(albumFacade.deleteAlbum(id), HttpStatus.OK);
		return result;
	}

}

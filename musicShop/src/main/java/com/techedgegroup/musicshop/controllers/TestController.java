package com.techedgegroup.musicshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techedgegroup.musicshop.DAO.AlbumDAO;
import com.techedgegroup.musicshop.DAO.MusicDAO;
import com.techedgegroup.musicshop.entities.Album;
import com.techedgegroup.musicshop.entities.Music;

@RestController
@RequestMapping("/rest")
public class TestController {
	
	@Autowired
	AlbumDAO albumRepository;
	
	@RequestMapping(value="/albumRepository", method=RequestMethod.GET)
	public String callAlbumRepository() {
		
		Album test = albumRepository.findById(2);
		//albumRepository.albumByStyleAndPublisher(null, null);
		//albumRepository.findById(1);
		
		return test.getName_album();
	}

	@Autowired
	MusicDAO musicRepository;
	
	@RequestMapping(value="/musicRepository", method=RequestMethod.GET)
	public String callMusicRepository() {
		
		Music music = musicRepository.findById(1);
		
		return music.getName_music();
	}
	

}

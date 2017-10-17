package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.techedgegroup.musicshop.entities.Album;
import com.techedgegroup.musicshop.entities.AlbumMusic;
import com.techedgegroup.musicshop.entities.Music;


public class AlbumDTO implements Serializable {

	private static final long serialVersionUID = 969431411823373640L;

	private Integer id;
	
	private String name_album;
	
	private String style;
	
	private String publisher;
	
	private Integer year;	

	private List<AlbumMusicDTO> listOfAlbumMusic;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName_album() {
		return name_album;
	}
	public void setName_album(String name_album) {
		this.name_album = name_album;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public List<AlbumMusicDTO> getListOfAlbumMusic() {
		return listOfAlbumMusic;
	}
	public void setListOfAlbumMusic(List<AlbumMusicDTO> listOfAlbumMusic) {
		this.listOfAlbumMusic = listOfAlbumMusic;
	}
	
	public AlbumDTO convertFromEntity(Album albumEntity) {
		
		AlbumDTO converted = new AlbumDTO();
		converted.setId(albumEntity.getId_album());
		
		
		List<AlbumMusicDTO> convertedAlbumMusic = new ArrayList<>();
		for(AlbumMusic alb : albumEntity.getListOfAlbumMusic()) {
			Music music = alb.getMusic();
			AlbumMusicDTO albDTO = new AlbumMusicDTO();
			BeanUtils.copyProperties(music, albDTO);
			convertedAlbumMusic.add(albDTO);
		}
		converted.setListOfAlbumMusic(convertedAlbumMusic);
		
		
		converted.setName_album(albumEntity.getName_album());
		converted.setPublisher(albumEntity.getPublisher());
		converted.setStyle(albumEntity.getStyle());
		converted.setYear(albumEntity.getYear());
		
		
		return converted;
	}
	
}

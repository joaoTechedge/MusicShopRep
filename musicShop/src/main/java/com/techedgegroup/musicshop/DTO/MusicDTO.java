package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.techedgegroup.musicshop.entities.AlbumMusic;
import com.techedgegroup.musicshop.entities.Music;
import com.techedgegroup.musicshop.entities.MusicStar;

public class MusicDTO implements Serializable {

	private static final long serialVersionUID = 4009535658806714493L;
	private Integer id;
	private String name_music;
	private String style_music;
	private double duraction;
	private String publisher;
	private Integer year; 

	private List<AlbumMusicDTO> listOfAlbumMusic;
	
	private List<MusicStarDTO> listOfMusicStar;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName_music() {
		return name_music;
	}
	public void setName_music(String name_music) {
		this.name_music = name_music;
	}
	public String getStyle_music() {
		return style_music;
	}
	public void setStyle_music(String style_music) {
		this.style_music = style_music;
	}
	public double getDuraction() {
		return duraction;
	}
	public void setDuraction(double duraction) {
		this.duraction = duraction;
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
	public List<MusicStarDTO> getListOfMusicStar() {
		return listOfMusicStar;
	}
	public void setListOfMusicStar(List<MusicStarDTO> listOfMusicStar) {
		this.listOfMusicStar = listOfMusicStar;
	}

	public MusicDTO convertFromEntity(Music musicEntity) {
		
		MusicDTO converted = new MusicDTO();
		converted.setDuraction(musicEntity.getDuraction());
		converted.setId(musicEntity.getId_music());
		List<AlbumMusicDTO> convertedAlbumMusic = new ArrayList<>();
		for(AlbumMusic alb : musicEntity.getListOfAlbumMusic()) {
			AlbumMusicDTO albDTO = new AlbumMusicDTO();
			BeanUtils.copyProperties(alb, albDTO);
			convertedAlbumMusic.add(albDTO);
		}
		converted.setListOfAlbumMusic(convertedAlbumMusic);
		
		List<MusicStarDTO> convertedMusicStar = new ArrayList<>();
		for(MusicStar alb : musicEntity.getListOfMusicStar()) {
			MusicStarDTO albDTO = new MusicStarDTO();
			BeanUtils.copyProperties(alb, albDTO);
			convertedMusicStar.add(albDTO);
		}
		converted.setListOfMusicStar(convertedMusicStar);
		
		converted.setName_music(musicEntity.getName_music());
		converted.setPublisher(musicEntity.getPublisher());
		converted.setStyle_music(musicEntity.getStyle_music());
		converted.setYear(musicEntity.getYear());
		
		return converted;
	}
	
	
}

package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;
import java.util.List;

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


	public Integer getId_music() {
		return id;
	}
	public void setId_music(Integer id_music) {
		this.id = id_music;
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

	
	
}

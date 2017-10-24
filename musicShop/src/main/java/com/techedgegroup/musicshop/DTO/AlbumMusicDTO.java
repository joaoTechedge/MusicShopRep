package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;

public class AlbumMusicDTO implements Serializable{

	private static final long serialVersionUID = -6842527008504370099L;

	private Integer id_music;
	private String name_music;
	private String style_music;
	private double duraction;
	private String publisher;
	private Integer year;
	
	public Integer getId_music() {
		return id_music;
	}
	public void setId_music(Integer id_music) {
		this.id_music = id_music;
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
	
	
	


}

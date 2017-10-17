package com.techedgegroup.musicshop.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="music")
public class Music {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_music", nullable = false)
	private Integer id;
	private String name_music;
	private String style_music;
	private double duraction;
	private String publisher;
	private Integer year; 

	@OneToMany(mappedBy="album", targetEntity=AlbumMusic.class)
	private List<AlbumMusic> listOfAlbumMusic;
	
	@OneToMany(mappedBy="music", targetEntity=MusicStar.class)
	private List<MusicStar> listOfMusicStar;


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
	public List<AlbumMusic> getListOfAlbumMusic() {
		return listOfAlbumMusic;
	}
	public void setListOfAlbumMusic(List<AlbumMusic> listOfAlbumMusic) {
		this.listOfAlbumMusic = listOfAlbumMusic;
	}
	public List<MusicStar> getListOfMusicStar() {
		return listOfMusicStar;
	}
	public void setListOfMusicStar(List<MusicStar> listOfMusicStar) {
		this.listOfMusicStar = listOfMusicStar;
	}

	
	
}

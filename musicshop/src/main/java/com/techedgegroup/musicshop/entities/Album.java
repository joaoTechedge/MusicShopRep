package com.techedgegroup.musicshop.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="album")
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_album;
	private String name_album;
	private String style;
	private String publisher;
	private Integer year;
	
    @OneToMany(mappedBy="album", targetEntity=AlbumBasket.class)
    private List<AlbumBasket> listOfAlbumBasket;

    @OneToMany(mappedBy="album", targetEntity=ShopAlbum.class)
    private List<ShopAlbum> listOfShopAlbum;

    @OneToMany(mappedBy="album", targetEntity=AlbumMusic.class)
    private List<AlbumMusic> listOfAlbumMusic;
	

	public Integer getId_album() {
		return id_album;
	}
	public void setId_album(Integer id_album) {
		this.id_album = id_album;
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
	
	
	public List<AlbumBasket> getListOfAlbumBasket() {
		return listOfAlbumBasket;
	}
	public void setListOfAlbumBasket(List<AlbumBasket> listOfAlbumBasket) {
		this.listOfAlbumBasket = listOfAlbumBasket;
	}
	public List<ShopAlbum> getListOfShopAlbum() {
		return listOfShopAlbum;
	}
	public void setListOfShopAlbum(List<ShopAlbum> listOfShopAlbum) {
		this.listOfShopAlbum = listOfShopAlbum;
	}
	public List<AlbumMusic> getListOfAlbumMusic() {
		return listOfAlbumMusic;
	}
	public void setListOfAlbumMusic(List<AlbumMusic> listOfAlbumMusic) {
		this.listOfAlbumMusic = listOfAlbumMusic;
	}
	
	

	
	

}

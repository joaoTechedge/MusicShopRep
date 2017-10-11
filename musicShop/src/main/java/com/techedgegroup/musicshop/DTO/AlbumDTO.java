package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.techedgegroup.musicshop.entities.Album;
import com.techedgegroup.musicshop.entities.AlbumBasket;
import com.techedgegroup.musicshop.entities.AlbumMusic;
import com.techedgegroup.musicshop.entities.ShopAlbum;


public class AlbumDTO implements Serializable {

	private static final long serialVersionUID = 969431411823373640L;

	private Integer id;
	
	private String name_album;
	
	private String style;
	
	private String publisher;
	
	private Integer year;	

	private List<AlbumBasketDTO> listOfAlbumBasket;

	private List<ShopAlbumDTO> listOfShopAlbum;

	private List<AlbumMusicDTO> listOfAlbumMusic;

	public Integer getId_album() {
		return id;
	}
	public void setId_album(Integer id_album) {
		this.id = id_album;
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
	public List<AlbumBasketDTO> getListOfAlbumBasket() {
		return listOfAlbumBasket;
	}
	public void setListOfAlbumBasket(List<AlbumBasketDTO> listOfAlbumBasket) {
		this.listOfAlbumBasket = listOfAlbumBasket;
	}
	public List<ShopAlbumDTO> getListOfShopAlbum() {
		return listOfShopAlbum;
	}
	public void setListOfShopAlbum(List<ShopAlbumDTO> listOfShopAlbum) {
		this.listOfShopAlbum = listOfShopAlbum;
	}
	public List<AlbumMusicDTO> getListOfAlbumMusic() {
		return listOfAlbumMusic;
	}
	public void setListOfAlbumMusic(List<AlbumMusicDTO> listOfAlbumMusic) {
		this.listOfAlbumMusic = listOfAlbumMusic;
	}
	
	public AlbumDTO convertFromEntity(Album albumEntity) {
		
		AlbumDTO converted = new AlbumDTO();
		converted.setId_album(albumEntity.getId_album());
		List<AlbumBasketDTO> convertedAlbumBasket = new ArrayList<>();
		for(AlbumBasket alb : albumEntity.getListOfAlbumBasket()) {
			AlbumBasketDTO albDTO = new AlbumBasketDTO();
			BeanUtils.copyProperties(alb, albDTO);
			convertedAlbumBasket.add(albDTO);
		}
		converted.setListOfAlbumBasket(convertedAlbumBasket);
		
		List<AlbumMusicDTO> convertedAlbumMusic = new ArrayList<>();
		for(AlbumMusic alb : albumEntity.getListOfAlbumMusic()) {
			AlbumMusicDTO albDTO = new AlbumMusicDTO();
			BeanUtils.copyProperties(alb, albDTO);
			convertedAlbumMusic.add(albDTO);
		}
		converted.setListOfAlbumMusic(convertedAlbumMusic);
		
		List<ShopAlbumDTO> convertedShopAlbum = new ArrayList<>();
		for(ShopAlbum alb : albumEntity.getListOfShopAlbum()) {
			ShopAlbumDTO albDTO = new ShopAlbumDTO();
			BeanUtils.copyProperties(alb, albDTO);
			convertedShopAlbum.add(albDTO);
		}
		converted.setListOfShopAlbum(convertedShopAlbum);
		
		converted.setName_album(albumEntity.getName_album());
		converted.setPublisher(albumEntity.getPublisher());
		converted.setStyle(albumEntity.getStyle());
		converted.setYear(albumEntity.getYear());
		
		
		return converted;
	}
}
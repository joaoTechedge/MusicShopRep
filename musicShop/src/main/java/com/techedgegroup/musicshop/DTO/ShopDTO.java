package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;
import java.util.List;

public class ShopDTO implements Serializable{

	private static final long serialVersionUID = 2016036497958628700L;
	private Integer id;
	private String name_shop;
	private String place;
	
	private List<ShopAlbumDTO> listOfShopAlbum;

	private List<TechUserDTO> listOfTechUser;

	private RegionDTO region;


	public Integer getId_shop() {
		return id;
	}
	public void setId_shop(Integer id_shop) {
		this.id = id_shop;
	}
	public String getName_shop() {
		return name_shop;
	}
	public void setName_shop(String name_shop) {
		this.name_shop = name_shop;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	public List<ShopAlbumDTO> getListOfShopAlbum() {
		return listOfShopAlbum;
	}
	public void setListOfShopAlbum(List<ShopAlbumDTO> listOfShopAlbum) {
		this.listOfShopAlbum = listOfShopAlbum;
	}



}

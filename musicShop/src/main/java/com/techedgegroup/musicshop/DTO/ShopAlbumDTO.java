package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;


public class ShopAlbumDTO implements Serializable{
	

	private static final long serialVersionUID = 6587168104735807861L;
	private Integer id;
	private boolean available;
	

	private ShopDTO shop;

	private AlbumDTO album;
	
	
	
	public Integer getId_shop_album() {
		return id;
	}
	public void setId_shop_album(Integer id_shop_album) {
		this.id = id_shop_album;
	}
	public ShopDTO getShop() {
		return shop;
	}
	public void setShop(ShopDTO shop) {
		this.shop = shop;
	}
	public AlbumDTO getAlbum() {
		return album;
	}
	public void setAlbum(AlbumDTO album) {
		this.album = album;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	

}

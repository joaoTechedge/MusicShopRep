package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;


public class AlbumBasketDTO implements Serializable{

	private static final long serialVersionUID = 8665232195556936725L;

	private Integer id;

	private BasketDTO basket;
	
	private AlbumDTO album;
	
	public Integer getId_album_basket() {
		return id;
	}
	public void setId_album_basket(Integer id_album_basket) {
		this.id = id_album_basket;
	}
	

	public BasketDTO getBasket() {
		return basket;
	}
	public void setBasket(BasketDTO basket) {
		this.basket = basket;
	}
	

	public AlbumDTO getAlbum() {
		return album;
	}
	public void setAlbum(AlbumDTO album) {
		this.album = album;
	}
	
	
}

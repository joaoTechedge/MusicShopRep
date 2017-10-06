package com.techedgegroup.musicshop.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="album_basket")
public class AlbumBasket {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_album_basket;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_basket")
	private Basket basket;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_album")
	private Album album;
	
	
	
	public Integer getId_album_basket() {
		return id_album_basket;
	}
	public void setId_album_basket(Integer id_album_basket) {
		this.id_album_basket = id_album_basket;
	}
	

	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	

	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
}

package com.techedgegroup.musicshop.entities;

import javax.persistence.*;

@Entity
@Table(name="shop_album")
public class ShopAlbum {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_shop_album", nullable = false)
	private Integer id;
	
	private boolean available;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_shop")
	private Shop shop;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_album")
	private Album album;
		
	public Integer getId_shop_album() {
		return id;
	}
	public void setId_shop_album(Integer id_shop_album) {
		this.id = id_shop_album;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	

}

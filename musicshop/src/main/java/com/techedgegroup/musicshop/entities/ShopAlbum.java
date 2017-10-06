package com.techedgegroup.musicshop.entities;

import javax.persistence.*;

@Entity
@Table(name="shop_album")
public class ShopAlbum {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_shop_album;
	private boolean isAvaiable;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_shop")
	private Shop shop;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_album")
	private Album album;
	
	
	
	public Integer getId_shop_album() {
		return id_shop_album;
	}
	public void setId_shop_album(Integer id_shop_album) {
		this.id_shop_album = id_shop_album;
	}

	public boolean isAvaiable() {
		return isAvaiable;
	}
	public void setAvaiable(boolean isAvaiable) {
		this.isAvaiable = isAvaiable;
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
	
	

}

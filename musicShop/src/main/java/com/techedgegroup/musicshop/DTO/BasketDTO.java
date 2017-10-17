package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class BasketDTO implements Serializable{

	private static final long serialVersionUID = -4452073874280851868L;
	private Integer id;
	private Date date_shop;
	private String send_address1;
	private String send_address2;

	private TechUserDTO techUser;
	private List<AlbumBasketDTO> listOfAlbumBasket;


	public Integer getId_basket() {
		return id;
	}
	public void setId_basket(Integer id_basket) {
		this.id = id_basket;
	}
	public Date getDate_shop() {
		return date_shop;
	}
	public void setDate_shop(Date date_shop) {
		this.date_shop = date_shop;
	}
	public String getSend_address1() {
		return send_address1;
	}
	public void setSend_address1(String send_address1) {
		this.send_address1 = send_address1;
	}
	public String getSend_address2() {
		return send_address2;
	}
	public void setSend_address2(String send_address2) {
		this.send_address2 = send_address2;
	}


	public TechUserDTO getTechUser() {
		return techUser;
	}
	public void setTechUser(TechUserDTO techUser) {
		this.techUser = techUser;
	}


	public List<AlbumBasketDTO> getListOfAlbumBasket() {
		return listOfAlbumBasket;
	}
	public void setListOfAlbumBasket(List<AlbumBasketDTO> listOfAlbumBasket) {
		this.listOfAlbumBasket = listOfAlbumBasket;
	}




}

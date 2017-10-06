package com.techedgegroup.musicshop.entities;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="basket")
public class Basket {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_basket;
	private Date date_shop;
	private String send_address1;
	private String send_address2;

	@ManyToOne
	@JoinColumn(name="id_user", referencedColumnName="id_user")
	private TechUser techUser    ;

	@OneToMany(mappedBy="basket", targetEntity=AlbumBasket.class)
	private List<AlbumBasket> listOfAlbumBasket;


	public Integer getId_basket() {
		return id_basket;
	}
	public void setId_basket(Integer id_basket) {
		this.id_basket = id_basket;
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


	public TechUser getTechUser() {
		return techUser;
	}
	public void setTechUser(TechUser techUser) {
		this.techUser = techUser;
	}


	public List<AlbumBasket> getListOfAlbumBasket() {
		return listOfAlbumBasket;
	}
	public void setListOfAlbumBasket(List<AlbumBasket> listOfAlbumBasket) {
		this.listOfAlbumBasket = listOfAlbumBasket;
	}




}

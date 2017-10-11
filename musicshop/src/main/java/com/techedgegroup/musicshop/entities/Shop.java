package com.techedgegroup.musicshop.entities;

import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="shop")
public class Shop {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_shop", nullable = false)
	private Integer id;
	private String name_shop;
	private String place;
	

	@OneToMany(mappedBy="shop", targetEntity=ShopAlbum.class)
	private List<ShopAlbum> listOfShopAlbum;

	@OneToMany(mappedBy="shop", targetEntity=TechUser.class)
	private List<TechUser> listOfTechUser;

	@ManyToOne
	@JoinColumn(name="id_region", referencedColumnName="id_region")
	private Region region;


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
	
	public List<ShopAlbum> getListOfShopAlbum() {
		return listOfShopAlbum;
	}
	public void setListOfShopAlbum(List<ShopAlbum> listOfShopAlbum) {
		this.listOfShopAlbum = listOfShopAlbum;
	}



}

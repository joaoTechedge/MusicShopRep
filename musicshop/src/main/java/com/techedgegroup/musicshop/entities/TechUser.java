package com.techedgegroup.musicshop.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tech_user")
public class TechUser {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_user;
	private String name_user;
	private Integer nif;
	private String addressLine1;
	private String addressLine2;
	private String postalCode;
	private boolean isActive;
	private Integer cellphone;
	private Integer type;

	@OneToMany(mappedBy="techUser", targetEntity=Region.class)
	private List<Region> listOfRegion;

	@ManyToOne
	@JoinColumn(name="id_shop", referencedColumnName="id_shop")
	private Shop shop        ;

	@OneToMany(mappedBy="techUser", targetEntity=Basket.class)
	private List<Basket> listOfBasket;

	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	public String getName_user() {
		return name_user;
	}
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}
	public Integer getNif() {
		return nif;
	}
	public void setNif(Integer nif) {
		this.nif = nif;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Integer getCellphone() {
		return cellphone;
	}
	public void setCellphone(Integer cellphone) {
		this.cellphone = cellphone;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public List<Region> getListOfRegion() {
		return listOfRegion;
	}
	public void setListOfRegion(List<Region> listOfRegion) {
		this.listOfRegion = listOfRegion;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public List<Basket> getListOfBasket() {
		return listOfBasket;
	}
	public void setListOfBasket(List<Basket> listOfBasket) {
		this.listOfBasket = listOfBasket;
	}

	

}

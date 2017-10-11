package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;
import java.util.List;

public class TechUserDTO implements Serializable{


	private static final long serialVersionUID = 968216911736340068L;
	private Integer id;
	private String name_user;
	private Integer nif;
	private String addressLine1;
	private String addressLine2;
	private String postalCode;
	private boolean isActive;
	private Integer cellphone;
	private Integer type;

	private List<RegionDTO> listOfRegion;

	private ShopDTO shop;

	private List<BasketDTO> listOfBasket;

	public Integer getId_user() {
		return id;
	}
	public void setId_user(Integer id_user) {
		this.id = id_user;
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
	public List<RegionDTO> getListOfRegion() {
		return listOfRegion;
	}
	public void setListOfRegion(List<RegionDTO> listOfRegion) {
		this.listOfRegion = listOfRegion;
	}
	public ShopDTO getShop() {
		return shop;
	}
	public void setShop(ShopDTO shop) {
		this.shop = shop;
	}
	public List<BasketDTO> getListOfBasket() {
		return listOfBasket;
	}
	public void setListOfBasket(List<BasketDTO> listOfBasket) {
		this.listOfBasket = listOfBasket;
	}

	

}

package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;
import java.util.List;


public class RegionDTO implements Serializable{

	private static final long serialVersionUID = -8788466433123614745L;
	private Integer id;
	private String name_region;

	private TechUserDTO techUser    ;

	private List<ShopDTO> listOfShop  ;

	public Integer getId_region() {
		return id;
	}
	public void setId_region(Integer id_region) {
		this.id = id_region;
	}
	public String getName_region() {
		return name_region;
	}
	public void setName_region(String name_region) {
		this.name_region = name_region;
	}
	public TechUserDTO getTechUser() {
		return techUser;
	}
	public void setTechUser(TechUserDTO techUser) {
		this.techUser = techUser;
	}
	public List<ShopDTO> getListOfShop() {
		return listOfShop;
	}
	public void setListOfShop(List<ShopDTO> listOfShop) {
		this.listOfShop = listOfShop;
	}




}

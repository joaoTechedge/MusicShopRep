package com.techedgegroup.musicshop.entities;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="region")
public class Region {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_region;
	private String name_region;

	@ManyToOne
	@JoinColumn(name="id_user", referencedColumnName="id_user")
	private TechUser techUser    ;

	@OneToMany(mappedBy="region", targetEntity=Shop.class)
	private List<Shop> listOfShop  ;

	public Integer getId_region() {
		return id_region;
	}
	public void setId_region(Integer id_region) {
		this.id_region = id_region;
	}
	public String getName_region() {
		return name_region;
	}
	public void setName_region(String name_region) {
		this.name_region = name_region;
	}
	public TechUser getTechUser() {
		return techUser;
	}
	public void setTechUser(TechUser techUser) {
		this.techUser = techUser;
	}
	public List<Shop> getListOfShop() {
		return listOfShop;
	}
	public void setListOfShop(List<Shop> listOfShop) {
		this.listOfShop = listOfShop;
	}




}

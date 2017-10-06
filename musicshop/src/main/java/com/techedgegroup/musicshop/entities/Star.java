package com.techedgegroup.musicshop.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="star")
public class Star {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_star;
	private String name_star;
	private String name_star_professional;
	private char gender;

	@OneToMany(mappedBy="star", targetEntity=MusicStar.class)
	private List<MusicStar> listOfMusicStar;


	public Integer getId_star() {
		return id_star;
	}
	public void setId_star(Integer id_star) {
		this.id_star = id_star;
	}
	public String getName_star() {
		return name_star;
	}
	public void setName_star(String name_star) {
		this.name_star = name_star;
	}
	public String getName_star_professional() {
		return name_star_professional;
	}
	public void setName_star_professional(String name_star_professional) {
		this.name_star_professional = name_star_professional;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public List<MusicStar> getListOfMusicStar() {
		return listOfMusicStar;
	}
	public void setListOfMusicStar(List<MusicStar> listOfMusicStar) {
		this.listOfMusicStar = listOfMusicStar;
	}


}

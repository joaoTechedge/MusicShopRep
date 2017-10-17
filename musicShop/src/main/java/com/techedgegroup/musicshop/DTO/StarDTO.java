package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.techedgegroup.musicshop.entities.MusicStar;
import com.techedgegroup.musicshop.entities.Star;


public class StarDTO implements Serializable{

	private static final long serialVersionUID = -8797933585362066286L;
	private Integer id;
	private String name_star;
	private String name_star_professional;
	private char gender;

	private List<MusicStarDTO> listOfMusicStar;


	public Integer getId_star() {
		return id;
	}
	public void setId_star(Integer id_star) {
		this.id = id_star;
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
	public List<MusicStarDTO> getListOfMusicStar() {
		return listOfMusicStar;
	}
	public void setListOfMusicStar(List<MusicStarDTO> listOfMusicStar) {
		this.listOfMusicStar = listOfMusicStar;
	}

	public StarDTO convertFromEntity(Star starEntity) {

		StarDTO converted = new StarDTO();
		converted.setId_star(starEntity.getId_star());
		converted.setGender(starEntity.getGender());
		converted.setName_star(starEntity.getName_star());
		converted.setName_star_professional(starEntity.getName_star_professional());
		
		converted.setListOfMusicStar(listOfMusicStar);
		List<MusicStarDTO> convertedMusicStar = new ArrayList<>();
		for(MusicStar mst : starEntity.getListOfMusicStar()) {
			MusicStarDTO mstDTO = new MusicStarDTO();
			BeanUtils.copyProperties(mst, mstDTO);
			convertedMusicStar.add(mstDTO);
		}
		converted.setListOfMusicStar(convertedMusicStar);

		return converted;

	}

}

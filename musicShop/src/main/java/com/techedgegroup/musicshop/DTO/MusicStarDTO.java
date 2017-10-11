package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;

public class MusicStarDTO implements Serializable{


	private Integer id;
	
	private Integer contribution;

	private MusicDTO music;

	private StarDTO star;

	
	public Integer getId_music_star() {
		return id;
	}

	public void setId_music_star(Integer id_music_star) {
		this.id = id_music_star;
	}

	public Integer getContribution() {
		return contribution;
	}

	public void setContribution(Integer contribution) {
		this.contribution = contribution;
	}

	public MusicDTO getMusic() {
		return music;
	}

	public void setMusic(MusicDTO music) {
		this.music = music;
	}

	public StarDTO getStar() {
		return star;
	}

	public void setStar(StarDTO star) {
		this.star = star;
	}
	
	
}

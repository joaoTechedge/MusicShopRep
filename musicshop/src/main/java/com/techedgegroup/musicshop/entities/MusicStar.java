package com.techedgegroup.musicshop.entities;

import javax.persistence.*;

@Entity
@Table(name="music_star")
public class MusicStar {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_music_star;
	
	private Integer contribution;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_music")
	private Music music;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_star")
	private Star star;

	
	public Integer getId_music_star() {
		return id_music_star;
	}

	public void setId_music_star(Integer id_music_star) {
		this.id_music_star = id_music_star;
	}

	public Integer getContribution() {
		return contribution;
	}

	public void setContribution(Integer contribution) {
		this.contribution = contribution;
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}
	
	
}

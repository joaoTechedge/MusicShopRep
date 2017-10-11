package com.techedgegroup.musicshop.entities;

import javax.persistence.*;

@Entity
@Table(name="album_music")
public class AlbumMusic {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_album_music", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_music")
	private Music music;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_album")
	private Album album;



	public Integer getId_album_music() {
		return id;
	}
	public void setId_album_music(Integer id_album_music) {
		this.id = id_album_music;
	}
	public Music getMusic() {
		return music;
	}
	public void setMusic(Music music) {
		this.music = music;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}



}

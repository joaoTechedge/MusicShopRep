package com.techedgegroup.musicshop.entities;

import javax.persistence.*;

@Entity
@Table(name="album_music")
public class AlbumMusic {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_album_music;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_music")
	private Music music;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_album")
	private Album album;



	public Integer getId_album_music() {
		return id_album_music;
	}
	public void setId_album_music(Integer id_album_music) {
		this.id_album_music = id_album_music;
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

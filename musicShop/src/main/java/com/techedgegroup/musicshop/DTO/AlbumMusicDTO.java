package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;

public class AlbumMusicDTO implements Serializable{

	private static final long serialVersionUID = -6842527008504370099L;

	private Integer id;

	private MusicDTO music;

	private AlbumDTO album;

	public Integer getId_album_music() {
		return id;
	}
	public void setId_album_music(Integer id_album_music) {
		this.id = id_album_music;
	}
	public MusicDTO getMusic() {
		return music;
	}
	public void setMusic(MusicDTO music) {
		this.music = music;
	}
	public AlbumDTO getAlbum() {
		return album;
	}
	public void setAlbum(AlbumDTO album) {
		this.album = album;
	}



}

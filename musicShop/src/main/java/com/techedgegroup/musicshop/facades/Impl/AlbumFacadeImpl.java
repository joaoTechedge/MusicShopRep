package com.techedgegroup.musicshop.facades.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.techedgegroup.musicshop.DAO.AlbumBasketDAO;
import com.techedgegroup.musicshop.DAO.AlbumDAO;
import com.techedgegroup.musicshop.DAO.AlbumMusicDAO;
import com.techedgegroup.musicshop.DTO.AlbumCriteriaDTO;
import com.techedgegroup.musicshop.DTO.AlbumDTO;
import com.techedgegroup.musicshop.DTO.AlbumMusicDTO;
import com.techedgegroup.musicshop.entities.Album;
import com.techedgegroup.musicshop.entities.AlbumBasket;
import com.techedgegroup.musicshop.entities.AlbumMusic;
import com.techedgegroup.musicshop.facades.AlbumFacade;

@Service
public class AlbumFacadeImpl implements AlbumFacade {

	@Autowired
	private AlbumDAO albumDAO;

	@Autowired
	private AlbumBasketDAO albumBasketDAO;

	@Autowired
	private AlbumMusicDAO albumMusicDAO;

	@Override
	public List<AlbumDTO> getAlbumList() throws Exception{
		try {
		List<Album> albumEntitys = (List<Album>) albumDAO.findAll();
		List<AlbumDTO> dto = new ArrayList<>();
		for(Album alb : albumEntitys) {
			AlbumDTO temp = new AlbumDTO().convertFromEntity(alb);
			dto.add(temp);
		}
		return dto;
		}catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public List<AlbumDTO> getAlbumListFiltered(AlbumCriteriaDTO criteria) throws Exception {
		try {
		Sort sort = getSort(criteria.getColumnName(), criteria.getDirection());
		criteria.setTextToSearch(criteria.getTextToSearch() != null ? "%"+criteria.getTextToSearch()+"%" : "%");
		List<Album> albumEntitys = (List<Album>) albumDAO.getAlbumsFiltered(criteria.getTextToSearch(),sort);
		List<AlbumDTO> dto = new ArrayList<>();
		for(Album alb : albumEntitys) {
			AlbumDTO temp = new AlbumDTO().convertFromEntity(alb);
			dto.add(temp);
		}
		return dto;
		}catch (Exception e) {
			throw new Exception();
		}
		
	}

	private Sort getSort(String columnName, String orderDir) {
		try {
			if(orderDir.equalsIgnoreCase("asc")) {
				return new Sort(Direction.ASC, columnName);
			}else {
				return new Sort(Direction.DESC, columnName);
			}
		}catch(NullPointerException e) {
			return new Sort(Direction.ASC, columnName);
		}
	}

	@Override
	public String createAlbum(AlbumDTO albumDTO) throws Exception{

		Album album = new Album();

		try {
			if(StringUtils.isEmpty(albumDTO.getName_album())) {
				throw new java.lang.Exception();
			}

			if(StringUtils.isEmpty(albumDTO.getPublisher())) {
				throw new java.lang.Exception();
			}

			if(StringUtils.isEmpty(albumDTO.getStyle())) {
				throw new java.lang.Exception();
			}

			if(StringUtils.isEmpty(albumDTO.getYear())) {
				throw new java.lang.Exception();
			}
		}catch (Exception e) {
			throw new Exception();
		}

		try {

			BeanUtils.copyProperties(albumDTO, album);
			album = albumDAO.save(album);

		}catch (Exception e) {
			throw new Exception();
		}
		return "Album inserted";
	}

	@Override
	public String updateAlbum(AlbumDTO albumDTO) throws Exception{

		Album album = albumDAO.findById(albumDTO.getId());
		List<AlbumMusic> albumMusic = album.getListOfAlbumMusic();
		List<AlbumMusicDTO> albumMusicDTO = albumDTO.getListOfAlbumMusic();


		try {
			if(StringUtils.isEmpty(albumDTO.getId())) {
				throw new java.lang.Exception();
			}

			if(StringUtils.isEmpty(albumDTO.getName_album())) {
				throw new java.lang.Exception();
			}

			if(StringUtils.isEmpty(albumDTO.getPublisher())) {
				throw new java.lang.Exception();
			}

			if(StringUtils.isEmpty(albumDTO.getStyle())) {
				throw new java.lang.Exception();
			}

			if(StringUtils.isEmpty(albumDTO.getYear())) {
				throw new java.lang.Exception();
			}

		}catch (Exception e) {
			throw new Exception();
		}

		try {


			BeanUtils.copyProperties(albumDTO, album);

			List<Integer> albumMusicToDelete = new ArrayList<>();

			for(AlbumMusic am: albumMusic) {
				boolean exists = false;
				for(AlbumMusicDTO amDTO:albumMusicDTO) {
					if(am.getMusic().getId_music().equals(amDTO.getId_music())) {
						exists = true;
					}
				}
				if(!exists) {
					albumMusicToDelete.add(am.getId_album_music());
				}
			}

			for(int idToDelete:albumMusicToDelete) {
				albumMusicDAO.delete(idToDelete);
				for(int i = albumMusic.size()-1; i > -1; i--) {
					if(albumMusic.get(i).getId_album_music().equals(idToDelete)) {
						albumMusic.remove(i);
					}
				}
			}

			album.setListOfAlbumMusic(albumMusic);		

			album = albumDAO.save(album);

		}catch (Exception e) {
			throw new Exception();
		}
		return "Album updated!";
	}

	@Override
	public String deleteAlbum(int id) throws Exception {

		try {
			if(StringUtils.isEmpty(id)) {
				throw new Exception();
			}

			List<AlbumBasket> albumBasket = (List<AlbumBasket>)albumBasketDAO.findAll();
			List<AlbumMusic> albumMusic = (List<AlbumMusic>)albumMusicDAO.findAll();

			for(AlbumBasket ab: albumBasket) {
				if(ab.getAlbum().getId_album().equals(id)) {
					throw new Exception();
				}
			}

			for(AlbumMusic am: albumMusic) {
				if(am.getAlbum().getId_album().equals(id)) {
					throw new Exception();
				}
			}
		}catch (Exception e) {
			throw new Exception();
		}

		try {
			albumDAO.delete(id);
		}catch (Exception e) {
			throw new Exception();
		}

		return "Album succefuly deleted!";
	}

}

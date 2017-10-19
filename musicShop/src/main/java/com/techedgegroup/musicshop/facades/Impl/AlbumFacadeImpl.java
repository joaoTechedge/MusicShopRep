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
	public List<AlbumDTO> getAlbumList() {
		List<Album> albumEntitys = (List<Album>) albumDAO.findAll();
		List<AlbumDTO> dto = new ArrayList<>();
		for(Album alb : albumEntitys) {
			AlbumDTO temp = new AlbumDTO().convertFromEntity(alb);
			dto.add(temp);
		}
		return dto;
	}

	@Override
	public List<AlbumDTO> getAlbumListFiltered(AlbumCriteriaDTO criteria) {
		Sort sort = getSort(criteria.getColumnName(), criteria.getDirection());
		criteria.setTextToSearch(criteria.getTextToSearch() != null ? "%"+criteria.getTextToSearch()+"%" : "%");
		List<Album> albumEntitys = (List<Album>) albumDAO.getAlbumsFiltered(criteria.getTextToSearch(),sort);
		List<AlbumDTO> dto = new ArrayList<>();
		for(Album alb : albumEntitys) {
			AlbumDTO temp = new AlbumDTO().convertFromEntity(alb);
			dto.add(temp);
		}
		return dto;
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
	public String createAlbum(AlbumDTO albumDTO) {
		
		Album album = new Album();
		
		if(StringUtils.isEmpty(albumDTO.getName_album())) {
			return "Name can not be empty!";
		}
		
		if(StringUtils.isEmpty(albumDTO.getPublisher())) {
			return "Publisher can not be empty!";
		}
		
		if(StringUtils.isEmpty(albumDTO.getStyle())) {
			return "Style can not be empty!";
		}
		
		if(StringUtils.isEmpty(albumDTO.getYear())) {
			return "Year can not be empty!";
		}
		
		BeanUtils.copyProperties(albumDTO, album);
		
		try {
		album = albumDAO.save(album);
		
		}catch (Exception e) {
			return "Album not inserted "+e;
		}
		return "Album inserted";
	}

	@Override
	public String updateAlbum(AlbumDTO albumDTO) {
		
		if(StringUtils.isEmpty(albumDTO.getId())) {
			return "Id can not be empty!";
		}
		
		if(StringUtils.isEmpty(albumDTO.getName_album())) {
			return "Name can not be empty!";
		}
		
		if(StringUtils.isEmpty(albumDTO.getPublisher())) {
			return "Publisher can not be empty!";
		}
		
		if(StringUtils.isEmpty(albumDTO.getStyle())) {
			return "Style can not be empty!";
		}
		
		if(StringUtils.isEmpty(albumDTO.getYear())) {
			return "Year can not be empty!";
		}
		
		try {
		Album album = albumDAO.findById(albumDTO.getId());
		
		BeanUtils.copyProperties(albumDTO, album);
		
		album = albumDAO.save(album);
		
		}catch (Exception e) {
			return "Album not updated "+e;
		}
		return "Album updated!";
	}

	@Override
	public String deleteAlbum(int id) {
		
		if(StringUtils.isEmpty(id)) {
			return "Id can not be empty!";
		}
		
		int idAlbum = id;
		List<AlbumBasket> albumBasket = (List<AlbumBasket>)albumBasketDAO.findAll();
		List<AlbumMusic> albumMusic = (List<AlbumMusic>)albumMusicDAO.findAll();
		
		for(AlbumBasket ab: albumBasket) {
			if(ab.getAlbum().getId_album().equals(idAlbum)) {
				return "This album can not be deleted. This album is in some basket";
			}
		}
		
		for(AlbumMusic am: albumMusic) {
			if(am.getAlbum().getId_album().equals(idAlbum)) {
				return "This album can not be deleted. Some musics are in this album";
			}
		}
		
		try {
			albumDAO.delete(idAlbum);
		}catch (Exception e) {
			return "Album not deleted!";
		}
						
		return "Album succefuly deleted!";
	}

}

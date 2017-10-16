package com.techedgegroup.musicshop.facades.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.techedgegroup.musicshop.DAO.AlbumDAO;
import com.techedgegroup.musicshop.DTO.AlbumCriteriaDTO;
import com.techedgegroup.musicshop.DTO.AlbumDTO;
import com.techedgegroup.musicshop.entities.Album;
import com.techedgegroup.musicshop.facades.AlbumFacade;

@Service
public class AlbumFacadeImpl implements AlbumFacade {

	@Autowired
	private AlbumDAO albumDAO;
	
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

		

}

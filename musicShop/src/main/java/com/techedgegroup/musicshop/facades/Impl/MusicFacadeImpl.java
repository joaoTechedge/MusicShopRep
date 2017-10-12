package com.techedgegroup.musicshop.facades.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.techedgegroup.musicshop.DAO.MusicDAO;
import com.techedgegroup.musicshop.DTO.MusicCriteriaDTO;
import com.techedgegroup.musicshop.DTO.MusicDTO;
import com.techedgegroup.musicshop.entities.Music;
import com.techedgegroup.musicshop.facades.MusicFacade;

@Service
public class MusicFacadeImpl implements MusicFacade {

	@Autowired
	private MusicDAO musicDAO;

	@Override
	public List<MusicDTO> getMusicList() {
		List<Music> musicEntitys = (List<Music>) musicDAO.findAll();
		List<MusicDTO> dto = new ArrayList<>();
		for(Music mus : musicEntitys) {
			MusicDTO temp = new MusicDTO().convertFromEntity(mus);
			dto.add(temp);
		}
		return dto;
	}

	@Override
	public List<MusicDTO> getMusicListFiltered(MusicCriteriaDTO criteria) {
		Sort sort = getSort(criteria.getColumnName(), criteria.getDirection());
		criteria.setTextToSearch(criteria.getTextToSearch() != null ? "%"+criteria.getTextToSearch()+"%" : "%");
		List<Music> musicEntitys = (List<Music>) musicDAO.getMusicFiltered(criteria.getTextToSearch(),sort);
		List<MusicDTO> dto = new ArrayList<>();
		for(Music mus : musicEntitys) {
			MusicDTO temp = new MusicDTO().convertFromEntity(mus);
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

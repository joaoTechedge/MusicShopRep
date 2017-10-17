package com.techedgegroup.musicshop.facades.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.techedgegroup.musicshop.DAO.StarDAO;
import com.techedgegroup.musicshop.DTO.StarCriteriaDTO;
import com.techedgegroup.musicshop.DTO.StarDTO;
import com.techedgegroup.musicshop.entities.Star;
import com.techedgegroup.musicshop.facades.StarFacade;

@Service
public class StarFacadeImpl implements StarFacade {

	@Autowired
	private StarDAO starDAO;

	@Override
	public List<StarDTO> getStarList() {
		List<Star> starEntitys = (List<Star>) starDAO.findAll();
		List<StarDTO> dto = new ArrayList<>();
		for(Star star : starEntitys) {
			StarDTO temp = new StarDTO().convertFromEntity(star);
			dto.add(temp);
		}
		return dto;
	}

	@Override
	public List<StarDTO> getStarListFiltered(StarCriteriaDTO criteria) {
		Sort sort = getSort(criteria.getColumnName(), criteria.getDirection());
		criteria.setTextToSearch(criteria.getTextToSearch() != null ? "%"+criteria.getTextToSearch()+"%" : "%");
		List<Star> starEntitys = (List<Star>) starDAO.getStarFiltered(criteria.getTextToSearch(),sort);
		List<StarDTO> dto = new ArrayList<>();
		for(Star star : starEntitys) {
			StarDTO temp = new StarDTO().convertFromEntity(star);
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

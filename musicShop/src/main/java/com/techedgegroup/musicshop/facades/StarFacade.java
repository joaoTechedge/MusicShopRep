package com.techedgegroup.musicshop.facades;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techedgegroup.musicshop.DTO.StarCriteriaDTO;
import com.techedgegroup.musicshop.DTO.StarDTO;

@Service
public interface StarFacade {
	
	public List<StarDTO> getStarList();

	public List<StarDTO> getStarListFiltered(StarCriteriaDTO dto);

}

package com.techedgegroup.musicshop.facades;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techedgegroup.musicshop.DTO.MusicCriteriaDTO;
import com.techedgegroup.musicshop.DTO.MusicDTO;

@Service
public interface MusicFacade {
	
	public List<MusicDTO> getMusicList();

	public List<MusicDTO> getMusicListFiltered(MusicCriteriaDTO dto);

}

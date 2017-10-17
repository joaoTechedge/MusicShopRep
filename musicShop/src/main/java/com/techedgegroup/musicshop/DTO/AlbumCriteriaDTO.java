package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;

public class AlbumCriteriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3848768527182721958L;
	
	private String columnName;
	
	private String direction;
	
	
	private String textToSearch;


	public String getColumnName() {
		return columnName;
	}


	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}


	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}


	public String getTextToSearch() {
		return textToSearch;
	}


	public void setTextToSearch(String textToSearch) {
		this.textToSearch = textToSearch;
	}
	
	

}

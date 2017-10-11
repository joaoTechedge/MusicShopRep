package com.techedgegroup.musicshop.DTO;

import java.io.Serializable;


public class VersionControllerDTO implements Serializable{


	private static final long serialVersionUID = 7307633592212901718L;
	private Integer id;
	private String script;
	
	
	public Integer getId_version() {
		return id;
	}
	public void setId_version(Integer id_version) {
		this.id = id_version;
	}
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	
	
	
}

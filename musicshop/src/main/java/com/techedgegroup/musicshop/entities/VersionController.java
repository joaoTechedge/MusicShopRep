package com.techedgegroup.musicshop.entities;

import javax.persistence.*;

@Entity
@Table(name="version_controller")
public class VersionController {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_version;
	private String script;
	
	
	public Integer getId_version() {
		return id_version;
	}
	public void setId_version(Integer id_version) {
		this.id_version = id_version;
	}
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	
	
	
}

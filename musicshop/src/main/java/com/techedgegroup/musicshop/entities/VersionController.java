package com.techedgegroup.musicshop.entities;

import javax.persistence.*;

@Entity
@Table(name="version_controller")
public class VersionController {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_version", nullable = false)
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

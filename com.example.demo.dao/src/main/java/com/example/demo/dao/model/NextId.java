package com.example.demo.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class NextId {

	@Id
	@GeneratedValue
	private long id;
	
	private String system;
	
	private String subSys;
	
	private String module;
	
	private String tableName;
	
	@Column(nullable=false)
	private long idPrefix;
	
	public NextId(){
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getSubSys() {
		return subSys;
	}
	public void setSubSys(String subSys) {
		this.subSys = subSys;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public long getIdPrefix() {
		return idPrefix;
	}
	public void setIdPrefix(long idPrefix) {
		this.idPrefix = idPrefix;
	}
	
	
}

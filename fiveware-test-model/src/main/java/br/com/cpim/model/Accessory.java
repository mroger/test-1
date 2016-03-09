package br.com.cpim.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="accessory")
public class Accessory {

	@Id
	private Integer idAccessory;
	private String description;
	
	public Accessory() {
		super();
	}
	
	public Accessory(Integer idAccessory) {
		super();
		this.idAccessory = idAccessory;
	}

	public Integer getIdAccessory() {
		return idAccessory;
	}
	public void setIdAccessory(Integer idAccessory) {
		this.idAccessory = idAccessory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Accessory [idAccessory=" + idAccessory + ", description=" + description + "]";
	}
	
}

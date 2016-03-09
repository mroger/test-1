package br.com.cpim.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entidade responsavel por manter os acessórios
 * 
 * @author Roger
 *
 */
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

	/**
	 * @return the idAccessory
	 */
	public Integer getIdAccessory() {
		return idAccessory;
	}

	/**
	 * @param idAccessory the idAccessory to set
	 */
	public void setIdAccessory(Integer idAccessory) {
		this.idAccessory = idAccessory;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Accessory [idAccessory=" + idAccessory + ", description=" + description + "]";
	}
	
}

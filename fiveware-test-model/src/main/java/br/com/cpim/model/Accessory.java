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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAccessory == null) ? 0 : idAccessory.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accessory other = (Accessory) obj;
		if (idAccessory == null) {
			if (other.idAccessory != null)
				return false;
		} else if (!idAccessory.equals(other.idAccessory))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Accessory [idAccessory=" + idAccessory + ", description=" + description + "]";
	}
	
}

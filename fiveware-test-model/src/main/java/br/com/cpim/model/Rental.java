package br.com.cpim.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Entidade responsavel por manter as locacoes dos veiculos.
 * 
 * @author Roger
 *
 */
@Entity(name="rental")
public class Rental {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idRental;
	private String brand;
	private String model;
	private String year;

	@ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name="RENTAL_ACCESSORY"
        , joinColumns={
            @JoinColumn(name="idRental")
            }
        , inverseJoinColumns={
            @JoinColumn(name="idAccessory")
            }
        )
	private List<Accessory> accessories;
	private String color;
	
	
	/**
	 * @return the idRental
	 */
	public Long getIdRental() {
		return idRental;
	}

	/**
	 * @param idRental the idRental to set
	 */
	public void setIdRental(Long idRental) {
		this.idRental = idRental;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the accessories
	 */
	public List<Accessory> getAccessories() {
		return accessories;
	}

	/**
	 * @param accessories the accessories to set
	 */
	public void setAccessories(List<Accessory> accessories) {
		this.accessories = accessories;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessories == null) ? 0 : accessories.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((idRental == null) ? 0 : idRental.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		Rental other = (Rental) obj;
		if (accessories == null) {
			if (other.accessories != null)
				return false;
		} else if (!accessories.equals(other.accessories))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (idRental == null) {
			if (other.idRental != null)
				return false;
		} else if (!idRental.equals(other.idRental))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rental [idRental=" + idRental + ", brand=" + brand + ", model=" + model + ", year=" + year
				+ ", accessories=" + accessories + ", color=" + color + "]";
	}
	
}

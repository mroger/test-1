package br.com.cpim.integration;

import java.util.Arrays;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Classe DTO entre o front-end e o controller web. 
 * 
 * @author Roger
 *
 */
public class RentalFormInput {

	private Long idRental;
	
	@NotBlank(message="A marca deve ser informada")
	private String brand;
	
	@NotBlank(message="O modelo deve ser informado")
	private String model;
	
	@NotBlank(message="O ano deve ser informado")
	private String year;
	
	@NotEmpty(message="Pelo menos um acessório deve ser informado")
	private Integer[] accessories;
	
	@NotBlank(message="A cor deve ser informada")
	private String color;
	
	public RentalFormInput() {
		super();
	}
	
	public RentalFormInput(String brand, String model, String year, Integer[] accessories,
			String color) {
		super();
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.accessories = accessories;
		this.color = color;
	}

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
	public Integer[] getAccessories() {
		return accessories;
	}

	/**
	 * @param accessories the accessories to set
	 */
	public void setAccessories(Integer[] accessories) {
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
		result = prime * result + Arrays.hashCode(accessories);
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
		RentalFormInput other = (RentalFormInput) obj;
		if (!Arrays.equals(accessories, other.accessories))
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
		return "RentalFormInput [brand=" + brand + ", model=" + model + ", year=" + year + ", accessories="
				+ Arrays.toString(accessories) + ", color=" + color + "]";
	}
	
}

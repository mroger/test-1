package br.com.cpim.integration;

import java.util.Arrays;

public class RentalFormInput {

	private Long idRental;
	private String brand;
	private String model;
	private String year;
	private Integer[] accessories;
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

	@Override
	public String toString() {
		return "RentalFormInput [brand=" + brand + ", model=" + model + ", year=" + year + ", accessories="
				+ Arrays.toString(accessories) + ", color=" + color + "]";
	}
	
}

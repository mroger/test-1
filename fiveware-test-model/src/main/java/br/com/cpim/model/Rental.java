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

	@Override
	public String toString() {
		return "Rental [idRental=" + idRental + ", brand=" + brand + ", model=" + model + ", year=" + year
				+ ", accessories=" + accessories + ", color=" + color + "]";
	}
	
}

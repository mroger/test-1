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
	public Long getIdRental() {
		return idRental;
	}
	public void setIdRental(Long idRental) {
		this.idRental = idRental;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public List<Accessory> getAccessories() {
		return accessories;
	}
	public void setAccessories(List<Accessory> accessories) {
		this.accessories = accessories;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Rental [idRental=" + idRental + ", brand=" + brand + ", model=" + model + ", year=" + year
				+ ", accessories=" + accessories + ", color=" + color + "]";
	}
	
}

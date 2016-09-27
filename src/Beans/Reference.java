package Beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="BeanReferences")
public class Reference implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	String brand;
	Float price;
	String description;
	public Reference(Integer id, String brand, Float price, String description) {
		super();
		this.id = id;
		this.brand = brand;
		this.price = price;
		this.description = description;
	}
	public Reference() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "References [id=" + id + ", brand=" + brand + ", price=" + price + ", description=" + description + "]";
	}
	
	
	
}

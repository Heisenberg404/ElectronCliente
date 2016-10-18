package Beans;

import java.io.Serializable;
import java.util.Arrays;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "beanProduct")
@ApplicationScoped
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer id;
	String name;
	Integer id_reference;
	Integer id_product_type;
	Integer quantity;
	Integer active;
	byte[] img;
	String ruta;
	
	
	
	
	public Product(Integer id, String name, Integer id_reference, Integer id_product_type, Integer quantity,
			Integer active, byte[] img, String ruta) {
		super();
		this.id = id;
		this.name = name;
		this.id_reference = id_reference;
		this.id_product_type = id_product_type;
		this.quantity = quantity;
		this.active = active;
		this.img = img;
		this.ruta = ruta;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", id_reference=" + id_reference + ", id_product_type="
				+ id_product_type + ", quantity=" + quantity + ", active=" + active + ", img=" + Arrays.toString(img)
				+ "]";
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId_reference() {
		return id_reference;
	}

	public void setId_reference(Integer id_reference) {
		this.id_reference = id_reference;
	}

	public Integer getId_product_type() {
		return id_product_type;
	}

	public void setId_product_type(Integer id_product_type) {
		this.id_product_type = id_product_type;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	

	
	
}

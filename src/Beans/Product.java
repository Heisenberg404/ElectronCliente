package Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	String routeImage;

	public Product(Integer id, String name, Integer id_reference, Integer id_product_type, Integer quantity,
			Integer active, String routeImage) {
		super();
		this.id = id;
		this.name = name;
		this.id_reference = id_reference;
		this.id_product_type = id_product_type;
		this.quantity = quantity;
		this.active = active;
		this.routeImage = routeImage;
	}

	public Product() {
		super();
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

	public String getRouteImage() {
		return routeImage;
	}

	public void setRouteImage(String routeImage) {
		this.routeImage = routeImage;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", id_reference=" + id_reference + ", id_product_type="
				+ id_product_type + ", quantity=" + quantity + ", active=" + active + ", routeImage=" + routeImage
				+ "]";
	}
	
//	public List<Product> createProducts(){
//		List<Product> list = new ArrayList<Product>();
//		list.add(new Product(1,"tv sony",1,1,10,1,"images/tv.jpg"));
//		list.add(new Product(1,"tv sony",1,1,10,1,"images/tv.jpg"));
//		list.add(new Product(1,"tv sony",1,1,10,1,"images/tv.jpg"));
//		list.add(new Product(1,"tv sony",1,1,10,1,"images/tv.jpg"));
//		list.add(new Product(1,"tv sony",1,1,10,1,"images/tv.jpg"));
//		list.add(new Product(1,"tv sony",1,1,10,1,"images/tv.jpg"));
//		list.add(new Product(1,"tv sony",1,1,10,1,"images/tv.jpg"));
//		return list;
//	}

}

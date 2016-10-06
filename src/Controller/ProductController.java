package Controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import Beans.Product;


@ManagedBean(name = "productController")
@ViewScoped
public class ProductController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Product> products;

	private Product selectedProduct;

	@ManagedProperty("#{beanProduct}")
	private Product product;

	@PostConstruct
	public void init() {
		
		products = product.createProducts();
		for (Product product : products) {
			System.out.println(product.getRouteImage().toString());
		}
	}

	public List<Product> getProducts() {
		
		return products;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}

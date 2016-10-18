package Controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultStreamedContent;
import Beans.Product;
import Model.ModelProduct;

@ManagedBean(name = "productController")
@ViewScoped
public class ProductController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Product> products;
	private Product selectedProduct;
	DefaultStreamedContent image;
	@ManagedProperty("#{beanProduct}")
	private Product product;
	private ModelProduct modelProduct = new ModelProduct();

	@PostConstruct
	public void init() {

		try {
			products = modelProduct.getProducts();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

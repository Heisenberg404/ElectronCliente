package Controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;

import Beans.Client;
import Beans.Product;
import Model.ModelProduct;

@ApplicationScoped
@ManagedBean(name = "productController")
public class ProductController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String filterRef;
	private List<Product> products;
	private Product selectedProduct;
	DefaultStreamedContent image;
	@ManagedProperty("#{beanProduct}")
	private Product product;
	@ManagedProperty("#{beanClient}")
	private Client client;
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
	
	public String getFilterRef() {
		return filterRef;
	}

	public void setFilterRef(String filterRef) {
		this.filterRef = filterRef;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

////////////////////////////////////////////
//                     METHODS            //
//                            PANEL       //
//                                 LEFT   //
///////////////////////////////////////////
	

    public DefaultStreamedContent getImage() {
		return image;
	}

	public void setImage(DefaultStreamedContent image) {
		this.image = image;
	}

	public ModelProduct getModelProduct() {
		return modelProduct;
	}

	public void setModelProduct(ModelProduct modelProduct) {
		this.modelProduct = modelProduct;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void filterListProductType(int filter){
    	List<Product> productsOri = new ArrayList<>();
    	try {
			for (Product product : modelProduct.getProducts()) {
				productsOri.add(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	products.clear();
    	for (Product product : productsOri) {
			if (product.getId_product_type() == filter) {
				products.add(product);
			}
		}
    }
    
    public void resetFilters(){
    	try {
			products = modelProduct.getProducts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void filterListByRef(String filterRef){
    	List<Product> productsOri = new ArrayList<>();
    	try {
			for (Product product : modelProduct.getProducts()) {
				productsOri.add(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	products.clear();
    	for (Product product : productsOri) {
			if (product.getName().contains(filterRef)) {
				products.add(product);
			}
		}
    }
}            



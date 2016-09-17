package Beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="prueba")
public class ProductType implements Serializable {

	private static final long serialVersionUID = 1L;

	private int product_type;

	private String type_name;

	public int getProduct_type() {
		return product_type;
	}

	public void setProduct_type(int productType) {
		product_type = productType;
	}

	public String getType_name() {
		return type_name;
	}

	public ProductType(int productType, String typeName) {
		super();
		product_type = productType;
		type_name = typeName;
	}

	public ProductType() {

	}

	@Override
	public String toString() {
		return "ProductType [ProductType=" + product_type + ", TypeName=" + type_name + "]";
	}

	public void setType_name(String typeName) {
		type_name = typeName;
	}
}

package Beans;
import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "beanBill")
@ApplicationScoped
public class Bill_detail implements Serializable{
	private static final long serialVersionUID = 1L;
	 Integer id_bill_detail;
	 Integer id_bill;
	 Integer id_product;
	 float unit_price;
	 Integer quantity;

	 public Bill_detail(Integer id_bill_detail, Integer id_bill, Integer id_product, float unit_price,Integer quantity) {
			super();
			this.id_bill_detail = id_bill_detail;
			this.id_bill = id_bill;
			this.id_product = id_product;
			this.unit_price = unit_price;
			this.quantity = quantity;
			
		}

		public Bill_detail() {
			
		}
		
		@Override
		public String toString() {
			return "Bill_detail [id_bill_detail=" + id_bill_detail + ", id_bill=" + id_bill + ", id_product=" + id_product + ",  quantity=" + quantity + ","
					+ "unit_price="+ unit_price + "]";
		}

		public Integer getId_bill_detail() {
			return id_bill_detail;
		}

		public void setId_bill_detail(Integer id_bill_detail) {
			this.id_bill_detail = id_bill_detail;
		}

		public Integer getId_bill() {
			return id_bill;
		}

		public void setId_bill(Integer id_bill) {
			this.id_bill = id_bill;
		}

		public Integer getId_product() {
			return id_product;
		}

		public void setId_product(Integer id_product) {
			this.id_product = id_product;
		}

		public float getUnit_price() {
			return unit_price;
		}

		public void setUnit_price(float unit_price) {
			this.unit_price = unit_price;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		
		

		
		
		
}

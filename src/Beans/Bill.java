package Beans;
import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "beanBill")
@ApplicationScoped
public class Bill implements Serializable{
	private static final long serialVersionUID = 1L;
	 Integer id_bill;
	 Integer id_client;
	 Date date_bill;
	 float value_bill;

	 public Bill(Integer id_bill, Integer id_client, Date date_bill, float value_bill) {
			super();
			this.id_bill = id_bill;
			this.id_bill = id_client;
			this.date_bill = date_bill;
			this.value_bill = value_bill;
			
		}

		public Bill() {
			
		}
		
		@Override
		public String toString() {
			return "Bill [id_bill=" + id_bill + ", id_client=" + id_client + ", date_bill=" + date_bill + ", value_bill="
					+ value_bill + "]";
		}

		public Integer getId_bill() {
			return id_bill;
		}

		public void setId_bill(Integer id_bill) {
			this.id_bill = id_bill;
		}

		public Integer getId_client() {
			return id_client;
		}

		public void setId_client(Integer id_client) {
			this.id_client = id_client;
		}

		public Date getDate_bill() {
			return date_bill;
		}

		public void setDate_bill(Date date_bill) {
			this.date_bill = date_bill;
		}

		public float getValue_bill() {
			return value_bill;
		}

		public void setValue_bill(float value_bill) {
			this.value_bill = value_bill;
		}
		
		
}

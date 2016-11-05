package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import Beans.Client;
import Beans.Bill;
import Beans.Bill_detail;
import Beans.Product;
import Model.ModelBillDetail;


@ManagedBean(name = "ControllerBillDetail")
@ApplicationScoped
public class BillDetailController implements Serializable{

	ModelBillDetail modelBillDetail = new ModelBillDetail();

	private static final long serialVersionUID = 1L;

	List<Product> lstBill = new ArrayList<Product>();
	
	
	
	
	
	
	float total  =5000;
	

	public float getTotal() {
		
		
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public List<Product> getLstBill() {
		return lstBill;
	}


	public void setLstBill(List<Product> lstBill) {
		this.lstBill = lstBill;
	}


	public BillDetailController(List<Product> ListParamet){
		
		lstBill = ListParamet;
		 

	
	}
	
	public BillDetailController() {
		super();
	}


	//@PostConstruct
	/*public void init() {
		try {
			//llenarLista();
			totalfactura();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public void addToCart(Product product){
		lstBill.add(product);
		
	}
	
	public void llenarLista()
	{
		List<Product> lstllenar = new ArrayList<Product>();	
		
		
		lstllenar.add(new Product(2,"moto",1,5000,4,1,null,"ruta",2222));
		lstllenar.add(new Product(2,"carro",2,5000,2,1,null,"ruta",2222));
		lstllenar.add(new Product(2,"moto",1,6000,3,1,null,"ruta",2222));
		lstllenar.add(new Product(2,"moto",2,7000,2,1,null,"ruta",2222));
		lstllenar.add(new Product(2,"moto",1,8000,1,1,null,"ruta",2222));
		
		lstBill=lstllenar;
		//id_client = 45;
	}
	public void totalfactura() throws Exception{
		//Bill_detail objTotal = new Bill_detail();
		for (Product objTotal : lstBill ){
			total = total + objTotal.getPrice();
		}
	}
	

		
	
	public void saveBill()
	{
		
		try {
			Client client = new Client();
			client.setPass("1234");
			client.setUsername("ale");
					
			modelBillDetail.saveBill(client,total,lstBill);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


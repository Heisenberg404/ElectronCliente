package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import Beans.Bill_detail;
import Beans.Product;
@RequestScoped
@ManagedBean(name = "ControllerBillDetail")
@ViewScoped
public class BillDetailController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	List<Product> lstBill = new ArrayList<Product>();
	Integer id_client;
	

	public List<Product> getLstBill() {
		return lstBill;
	}


	public void setLstBill(List<Product> lstBill) {
		this.lstBill = lstBill;
	}


	public Integer getId_client() {
		return id_client;
	}


	public void setId_client(Integer id_client) {
		this.id_client = id_client;
	}


	public BillDetailController(List<Product> ListParamet, Integer client){
		
		lstBill = ListParamet;
		id_client = client;
	
	}
	
	public BillDetailController() {
		super();
	}


	@PostConstruct
	public void init() {
		try {
			llenarLista();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		id_client = 45;
	}
	
	
	

}


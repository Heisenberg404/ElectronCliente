package Controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Beans.Client;
import Beans.Bill;
import Beans.Bill_detail;
import Beans.Product;
import Model.ModelBillDetail;

@ApplicationScoped
@ManagedBean(name = "ControllerBillDetail")
public class BillDetailController implements Serializable{

	ModelBillDetail modelBillDetail = new ModelBillDetail();
	private static final long serialVersionUID = 1L;
	List<Product> lstBill = new ArrayList<Product>();	
	
	//to do change to float
	int total;
	
	
	public void setTotal(int total) {
		this.total = total;
	}


	public float getTotal() {
		
		
		return total;
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

	public void addToCart(Product product){
		lstBill.add(product);
		total += product.getPrice(); 
		
	}
		
	
	public void saveBill(Client client)
	{
		
		try {
			float totalF = (float)total; 
			modelBillDetail.saveBill(client,totalF,lstBill);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void redirectToCart(String username) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Facturacion.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


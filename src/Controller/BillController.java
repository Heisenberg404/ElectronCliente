package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import Beans.Bill_detail;

import Model.ModelBill;





@RequestScoped
@ManagedBean(name = "ControllerBill")
@ViewScoped
public class BillController implements Serializable{
	
/**>
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private static final long serialVersionUID = 1L;

	ModelBill modelBill = new ModelBill();
	
	List<Bill_detail> lstBill = new ArrayList<Bill_detail>();
	
	public List<Bill_detail> getLstBill(){
		return lstBill;
	}

	public void setLstBill(List<Bill_detail> lstBill) {
		this.lstBill = lstBill;
	}
	
	
	
	
	
	
	
	
}
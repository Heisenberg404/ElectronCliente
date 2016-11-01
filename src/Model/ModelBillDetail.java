package Model;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import Beans.Bill;
import Beans.Bill_detail;
import Beans.Product;
import Utils.Conection;

public class ModelBillDetail {
	public ModelBillDetail(){
	super();
	}
	Conection conn = new Conection();
	public void saveBill(Bill bill, List<Product> lstProduct) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_BILL.Create_bill(?,?,?,?,?)}"); //MODIFICAR EL PROCEDIMIENTO PARA QUE DEVUELVA EL NUMERO DE LA FACTURA 
		// Parametros del procedimiento almacenado
		cs.setInt(1, bill.getId_client());
		cs.setDate(2, bill.getDate_bill());
		cs.setFloat(3, bill.getValue_bill());
		
		// Definimos los tipos de los parametros de salida del procedimiento
		// almacenado
		cs.registerOutParameter(4, java.sql.Types.INTEGER);
		cs.registerOutParameter(5, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
		int back1 = cs.getInt(4);
		String back = cs.getString(5);
		
		System.out.println(back1);
		System.out.println(back);
		saveBillDetail(back1, lstProduct);
		con.close();
}

	
public void saveBillDetail(int num_factura, List<Product> lstProduct) throws Exception{		
		//Billdetail objDetail =new Billdetail();
		Connection con = conn.getConnection();
		for(Product objDetail : lstProduct )
		//for(int i=0; i < lstProduct.size(); i++) 
		{
            //objDetail = lstProduct.get(i);
        
		
			CallableStatement cs2 = null;
			cs2 = con.prepareCall("{call PKG_BILLDETAIL.Create_bill_detail(?,?,?,?,?)}");
			// Parametros del procedimiento almacenado
			cs2.setInt(1, num_factura);
			cs2.setInt(2, objDetail.getId());
			cs2.setFloat(3, objDetail.getPrice());
			cs2.setInt(4, objDetail.getQuantity());
			
			
			// Definimos los tipos de los parametros de salida del procedimiento
			// almacenado
			cs2.registerOutParameter(5, java.sql.Types.VARCHAR);
			cs2.execute();
			// Se obtienen la salida del procedimineto almacenado
			String back = cs2.getString(5);
			System.out.println(back);
		
		}
		
		con.close();
	}
	
	



	
}
	


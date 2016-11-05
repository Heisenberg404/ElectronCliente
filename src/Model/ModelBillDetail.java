package Model;


import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Beans.Client;
import Beans.Bill;
import Beans.Bill_detail;
import Beans.Product;

import Utils.Conection;
import oracle.jdbc.OracleTypes;

public class ModelBillDetail {
	public ModelBillDetail(){
	super();
	}
	Conection conn = new Conection();
	public void saveBill(Client id_client, float total, List<Product> lstProduct) throws Exception {
		Connection con = conn.getConnection();
		Client cli = new Client();
		//Date fecha = 
		/*DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fechaString = dateFormat.format(fecha);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha2 = (Date) formato.parse(fechaString);*/
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		cli = getDataClient(id_client);
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_BILL.Create_bill(?,?,?,?,?)}"); //MODIFICAR EL PROCEDIMIENTO PARA QUE DEVUELVA EL NUMERO DE LA FACTURA 
		// Parametros del procedimiento almacenado
		cs.setInt(1, cli.getId_client());
		cs.setDate(2, date);
		cs.setFloat(3, total);
		
		// Definimos los tipos de los parametros de salida del procedimiento
		// almacenado
		cs.registerOutParameter(4, java.sql.Types.VARCHAR);
		cs.registerOutParameter(5, java.sql.Types.INTEGER);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
		
		String back = cs.getString(4);
		int back1 = cs.getInt(5);
		
		System.out.println(back1);
		System.out.println(back);
		saveBillDetail(back1, lstProduct);
		con.close();
}
	
	public Client getDataClient(Client cli) throws Exception{
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		ResultSet rs = null;
		cs = con.prepareCall("{call PKG_CLIENT.Specific_Read(?,?,?)}");
		// Parametros del procedimiento almacenado
		cs.setString(1, cli.getUsername());
		cs.setString(2, cli.getPass());
		cs.registerOutParameter(3, OracleTypes.CURSOR);
		cs.execute();
		rs = (ResultSet) cs.getObject(3);
		Client datoClient = new Client();
		while (rs.next()) {
			

			datoClient.setId_client(rs.getInt("ID_CLIENT"));
			
		}
		con.close();
		return datoClient;
		
		
	}

	
public void saveBillDetail(int num_factura, List<Product> lstProduct) throws Exception{		
		//Billdetail objDetail =new Billdetail();
		Connection con = conn.getConnection();
		for(Product objDetail : lstProduct )
		//for(int i=0; i < lstProduct.size(); i++) 
		{
            //objDetail = lstProduct.get(i);
        
		
			CallableStatement cs2 = null;
			cs2 = con.prepareCall("{call PKG_BILL_DETAIL.Create_bill_detail(?,?,?,?,?)}");
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
	


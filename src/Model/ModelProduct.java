package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Beans.Product;
import Utils.Conection;
import oracle.jdbc.OracleTypes;

public class ModelProduct {
	Conection conn = new Conection();
	List<Product> lstProducts = new ArrayList<Product>();
	
	public List<Product> getProducts() throws Exception{
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		ResultSet rs = null;
		cs = con.prepareCall("{call PKG_PRODUCTS.Read_PRODUCTS(?)}");
		cs.registerOutParameter(1, OracleTypes.CURSOR);
		cs.execute();
		rs = (ResultSet) cs.getObject(1);
		
		while (rs.next()) 
		{
			System.out.println(rs.getInt("ID_PRODUCT"));
//			Product pr = new Product();
//			
//			pr.setId_product();
//			pr.setProduct_name(rs.getString("PRODUCT_NAME"));
//			pr.setId_reference(rs.getInt("ID_REFERENCE"));
//			pr.setId_product_type(rs.getInt("ID_PRODUCT_TYPE"));
//			pr.setQuantity(rs.getInt("QUANTITY"));
//			pr.setActive(rs.getInt("ACTIVE"));
//			
//			lstProducts.add(pr);
		}
		
		return lstProducts;
	}
	
}

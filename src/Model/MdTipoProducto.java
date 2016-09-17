package Model;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.faces.bean.ManagedBean;

import Beans.ProductType;
import Utils.Conection;

@ManagedBean(name="mdtp")
public class MdTipoProducto {

	Conection conn = new Conection();

	public void AgregarTp(ProductType pt) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PROCESOSPRODUCTTYPE.AGREGAR(?)}");
		cs.setString(1, pt.getType_name());
		cs.execute();

	}
}

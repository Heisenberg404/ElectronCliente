package Controller;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import Model.ProductType;
import Utils.Conection;
@RequestScoped
@ManagedBean(name="ct_tp")
@ViewScoped
public class ct_tipo_producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void AgregarTp(ProductType pt) throws SQLException {
		Connection con = Conection.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PROCESOSPRODUCTTYPE.AGREGAR(?)}");
		cs.setString(1, pt.getType_name());
		cs.execute();
		
	}
}

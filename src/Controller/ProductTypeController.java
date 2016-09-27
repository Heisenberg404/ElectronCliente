package Controller;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import Beans.ProductType;
import Model.MdTipoProducto;
import Utils.Conection;

@RequestScoped
@ManagedBean(name = "ct_tp")
@ViewScoped
public class ct_tipo_producto implements Serializable {

	private static final long serialVersionUID = 1L;
	MdTipoProducto mdtp = new MdTipoProducto();

	public void agregarTp(ProductType pt) throws Exception {
		mdtp.AgregarTp(pt);
	}
}

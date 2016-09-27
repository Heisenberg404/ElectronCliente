package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import Beans.Reference;
import Utils.Conection;

public class ModelReference {
	

	public ModelReference() {
		super();
	}

	Conection conn = new Conection();

	public void saveReference(Reference ref) throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		cs = con.prepareCall("{call PKG_REFERENCES_PRODUCT.create_REFERENCES_PRODUCT(?,?,?,?)}");
		 // Parametros del procedimiento almacenado
		cs.setString(1, ref.getBrand());
		cs.setString(1, ref.getBrand());
		cs.setFloat(2, ref.getPrice());
		cs.setString(3, ref.getDescription());
		// Definimos los tipos de los parametros de salida del procedimiento almacenado
        cs.registerOutParameter(4, java.sql.Types.VARCHAR);
		cs.execute();
		// Se obtienen la salida del procedimineto almacenado
        String back = cs.getString(4);
        System.out.println(back);

	}
}

package Model;

import java.awt.Image;
import java.awt.Toolkit;
import java.beans.Statement;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.script.ScriptContext;
import javax.swing.ImageIcon;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.push.inject.ServletContextInjectable;

import Beans.Product;
import Utils.Conection;
import oracle.jdbc.OracleTypes;

public class ModelProduct {

	Conection conn = new Conection();
	List<Product> lstProducts = new ArrayList<Product>();
	private StreamedContent graphicImage;
	public String path = "";

	public List<Product> getProducts() throws Exception {
		Connection con = conn.getConnection();
		CallableStatement cs = null;
		ResultSet rs = null;
		cs = con.prepareCall("{call PKG_PRODUCTS.Read_PRODUCTS(?)}");
		cs.registerOutParameter(1, OracleTypes.CURSOR);
		cs.execute();
		rs = (ResultSet) cs.getObject(1);

		while (rs.next()) {
			// System.out.println(rs.getInt("ID_PRODUCT"));
			Product pr = new Product();

			pr.setId(rs.getInt("ID_PRODUCT"));
			pr.setName(rs.getString("PRODUCT_NAME"));
			pr.setId_reference(rs.getInt("ID_REFERENCE"));
			pr.setId_product_type(rs.getInt("ID_PRODUCT_TYPE"));
			pr.setQuantity(rs.getInt("QUANTITY"));
			pr.setActive(rs.getInt("ACTIVE"));
			pr.setImg(rs.getBytes("BLOB_IMAGE"));
			if (pr.getImg() != null) {
				pr.setRuta(guardarBlobTemp(pr.getImg(), pr.getName()));
			}
			lstProducts.add(pr);
		}

		return lstProducts;
	}

	public String guardarBlobTemp(byte[] bytes, String nombreArchivo) {
		String locationImage = null;
//		nombreArchivo.replaceAll("\\s", "");
//		nombreArchivo.toLowerCase();
//		String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
		 path = "C:\\Users\\Alexandra Ardila\\git\\ElectronCliente\\WebContent\\Views\\images";
		// String path =
		// servletContext.getExternalContext().getRealPath("")+"\\resources\\images\\tmp"+nombreArchivo+".jpg";
		File f = new File(path + nombreArchivo + ".jpg");
		// if(!f.exists()){
		InputStream in;
		if (bytes != null) {
			try {
				in = new ByteArrayInputStream(bytes);

				FileOutputStream out = new FileOutputStream(f.getAbsolutePath());
				int c;
				while ((c = in.read()) >= 0) {
					out.write(c);
				}
				out.flush();
				out.close();
				locationImage = "images/" + nombreArchivo + ".jpg";
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return locationImage;

	}
}

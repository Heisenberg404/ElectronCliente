package Model;

import java.io.IOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import Beans.Bill;
import Beans.Bill_detail;
import Utils.Conection;

public class ModelBill {
	public ModelBill() {
		super();
	}
	Conection conn = new Conection();
	
}

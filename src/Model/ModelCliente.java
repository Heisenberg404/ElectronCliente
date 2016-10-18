package Model;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import Beans.Client;
import Utils.Conection;

public class ModelCliente {
	public ModelCliente() {
		super();
	}

	Conection conn = new Conection();
	
	public void iniciarSesion(Client cli) throws Exception {
        Connection con = conn.getConnection();
        CallableStatement cs = null;
        cs = con.prepareCall("{call PKG_Client.QueryClient(?,?,?)}");
        // Parametros del procedimiento almacenado
        cs.setString(1, cli.getUsername());
        cs.setString(2, cli.getPass());
        // Definimos los tipos de los parametros de salida del procedimiento
        // almacenado
        cs.registerOutParameter(3, java.sql.Types.VARCHAR);
        cs.execute();
        // Se obtienen la salida del procedimineto almacenado     
        String back = cs.getString(3);
        System.out.println(back);       
        System.out.println(back);    
        
        if (back.equals("YES")) {

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", cli);
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } else {
        	
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"Error","User no existe")); 
        }

    }
    
    public void checkSession() {
        try {
            Client cli = (Client) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
            if (cli == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("LoginClient.xhtml");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void closeSession() throws IOException{        
//        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();    
    }
	

}

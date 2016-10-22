package Controller;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;


import Beans.Client;

import Model.ModelCliente;


@RequestScoped
@ManagedBean(name = "ControllerClient")
@ViewScoped

public class ClientController implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
	ModelCliente modelClient = new ModelCliente();
	
	public void saveClient(Client Clients){
		try {
			modelClient.saveClient(Clients);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void checkSession() throws Exception {
        modelClient.checkSession();
    }

    public void iniciarSesion(Client client) {
        try {
            modelClient.iniciarSesion(client);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void closeSession()
    {
        try {
        	modelClient.closeSession();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


		
	

}

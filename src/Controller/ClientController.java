package Controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import Beans.Client;
import Model.ModelCliente;


@ApplicationScoped
@ManagedBean(name = "ControllerClient")
public class ClientController implements Serializable {

	private static final long serialVersionUID = 1L;
	ModelCliente modelClient = new ModelCliente();
	@ManagedProperty("#{beanClient}")
	public Client sessionClient;

	public void saveClient(Client Clients) {
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
			sessionClient = modelClient.iniciarSesion(client);
			System.out.println("USER: "+sessionClient.getUsername());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeSession() {
		try {
			modelClient.closeSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Client getSessionClient() {
		return sessionClient;
	}

	public void setSessionClient(Client sessionClient) {
		this.sessionClient = sessionClient;
	}
	
	

}

package Beans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ApplicationScoped
@ManagedBean(name = "beanClient")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id_client;
	private String name_client;
	private Integer document_client;
	private String gender;
	private String username;
	private String pass;

	public Client(Integer id_client, String name_client, Integer document_client, String gender, String username,
			String pass) {
		super();
		this.id_client = id_client;
		this.name_client = name_client;
		this.document_client = document_client;
		this.gender = gender;
		this.username = username;
		this.pass = pass;

	}

	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", name_client" + name_client + "," + "document_client="
				+ document_client + ", gender=" + gender + "," + " username=" + username + ", pass=" + pass + "]";
	}

	public Client() {

	}

	public Integer getId_client() {
		return id_client;
	}

	public void setId_client(Integer id_client) {
		this.id_client = id_client;
	}

	public String getName_client() {
		return name_client;
	}

	public void setName_client(String name_client) {
		this.name_client = name_client;
	}

	public Integer getDocument_client() {
		return document_client;
	}

	public void setDocument_client(Integer document_client) {
		this.document_client = document_client;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}

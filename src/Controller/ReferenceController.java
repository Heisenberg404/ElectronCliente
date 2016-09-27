package Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import Beans.Reference;
import Model.ModelReference;

@RequestScoped
@ManagedBean(name = "referencesController")
@ViewScoped
public class ReferenceController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	ModelReference modelReference = new ModelReference();
	
	public void saveReference(Reference reference){
		try {
			modelReference.saveReference(reference);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

package fr.treeptik.controlleur;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Administrateur;
import fr.treeptik.model.Formateur;
import fr.treeptik.service.FormateurService;

@ManagedBean
@SessionScoped
public class FormateurControlleur {
	
	private Formateur formateur = new Formateur();
	
	@EJB
	private FormateurService formateurService;
	
	private List<Formateur> listFormateur = new ArrayList<Formateur>();
	
	@SuppressWarnings("rawtypes")
	private DataModel formateurs;
	public String prepareCreate(){
		formateur = new Formateur();
		return "createFormateur";
	}
	
	public String doCreate() throws ServiceException{
		if(formateur.getId()!=null){
			formateurService.update(formateur);
		}else{
			formateurService.add(formateur);
		}
		return "succesCreation";
	}
	
	@SuppressWarnings("rawtypes")
	public String doDelete() throws ServiceException{
		Formateur f = (Formateur)formateurs.getRowData();
		formateurService.delete(f.getId());
		formateurs = new ListDataModel();
		formateurs.setWrappedData(formateurService.getAll());
		return "listAdmin";
	}
	
	public String doSelectUpdate(){
		formateur = (Formateur)formateurs.getRowData();
		return "createFormateur";
	}
	
	public Formateur getFormateur() {
		return formateur;
	}
	
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	
	public List<Formateur> getListFormateur() {
		return listFormateur;
	}

	public void setListFormateur(List<Formateur> listFormateur) {
		this.listFormateur = listFormateur;
	}
	
	@SuppressWarnings("rawtypes")
	public DataModel getFormateurs() {
		if(formateurs== null){
			formateurs = new ListDataModel();
		}
			try {
				formateurs.setWrappedData(formateurService.getAll());
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		return formateurs;
	}
	
	@SuppressWarnings("rawtypes")
	public void setFormateurs(DataModel formateurs) {
		this.formateurs = formateurs;
	}
}

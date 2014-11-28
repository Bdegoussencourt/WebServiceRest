package fr.treeptik.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Evaluation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nom;
	private String descriptif;
	@OneToMany(mappedBy="evaluation")
	private List<Questionnaire> listQuestionnaires;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescriptif() {
		return descriptif;
	}
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	public List<Questionnaire> getListQuestionnaires() {
		return listQuestionnaires;
	}
	public void setListQuestionnaires(List<Questionnaire> listQuestionnaires) {
		this.listQuestionnaires = listQuestionnaires;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Evaluation [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", descriptif=");
		builder.append(descriptif);
		builder.append("]");
		return builder.toString();
	}
	

}

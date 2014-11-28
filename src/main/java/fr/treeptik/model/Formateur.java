package fr.treeptik.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Formateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String nom;
	private String prenom;
	private String specialite;
	@ManyToOne
	private Evaluation evaluation;
	@ManyToMany
	private List<Formation> listFormations;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public Evaluation getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
	public List<Formation> getListFormations() {
		return listFormations;
	}
	public void setListFormations(List<Formation> listFormations) {
		this.listFormations = listFormations;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Formateur [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", specialite=");
		builder.append(specialite);
		builder.append("]");
		return builder.toString();
	}
	

}

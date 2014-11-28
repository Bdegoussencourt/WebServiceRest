package fr.treeptik.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Session implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nom;
	@Temporal(TemporalType.DATE)
	private Date dateDebutStage;
	@Temporal(TemporalType.DATE)
	private Date dateFinStage;
	private String Descriptif;
	@ManyToMany
	private List<Stagiaire> listStagiaires;
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
	public Date getDateDebutStage() {
		return dateDebutStage;
	}
	public void setDateDebutStage(Date dateDebutStage) {
		this.dateDebutStage = dateDebutStage;
	}
	public Date getDateFinStage() {
		return dateFinStage;
	}
	public void setDateFinStage(Date dateFinStage) {
		this.dateFinStage = dateFinStage;
	}
	public String getDescriptif() {
		return Descriptif;
	}
	public void setDescriptif(String descriptif) {
		Descriptif = descriptif;
	}
	public List<Stagiaire> getListStagiaires() {
		return listStagiaires;
	}
	public void setListStagiaires(List<Stagiaire> listStagiaires) {
		this.listStagiaires = listStagiaires;
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
		builder.append("Session [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", dateDebutStage=");
		builder.append(dateDebutStage);
		builder.append(", dateFinStage=");
		builder.append(dateFinStage);
		builder.append(", Descriptif=");
		builder.append(Descriptif);
		builder.append("]");
		return builder.toString();
	}

	
}

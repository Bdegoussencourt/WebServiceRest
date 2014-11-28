package fr.treeptik.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Formation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 50)
	private String nom;
	private String descriptif;
	@ManyToMany(mappedBy = "listFormations")
	private List<Formateur> listFormateurs;
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
	public List<Formateur> getListFormateurs() {
		return listFormateurs;
	}
	public void setListFormateurs(List<Formateur> listFormateurs) {
		this.listFormateurs = listFormateurs;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Formation [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", descriptif=");
		builder.append(descriptif);
		builder.append("]");
		return builder.toString();
	}
	
}

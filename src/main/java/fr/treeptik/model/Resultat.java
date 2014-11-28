package fr.treeptik.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Resultat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer note;
	private String commentaire;
	@ManyToOne
	private Evaluation evaluation;
	@ManyToOne
	private Questionnaire questionnaire;
	@ManyToOne
	private Question question;
	@ManyToOne
	private Formation formation;
	@ManyToOne
	private Formateur formateur;
	@ManyToOne
	private Stagiaire stagiaire;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	
	public Evaluation getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Stagiaire getStagiaire() {
		return stagiaire;
	}
	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Resultat [id=");
		builder.append(id);
		builder.append(", note=");
		builder.append(note);
		builder.append(", commentaire=");
		builder.append(commentaire);
		builder.append("]");
		return builder.toString();
	}
	

}

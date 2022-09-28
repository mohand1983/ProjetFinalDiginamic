package fr.diginamic.labonnerando.modeles;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Participation {

	// attributs de la classe Participation

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	@Column(name = "date_inscription")
	@ColumnDefault(value = "(CURDATE())")
	private LocalDateTime dateInscription;

	private Boolean isOrganisateur;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_evenement", referencedColumnName = "id")
	private Evenement evenement;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
	private Utilisateur utilisateur;

	// Constructeur

	// Getters et setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(LocalDateTime dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Boolean getIsOrganisateur() {
		return isOrganisateur;
	}

	public void setIsOrganisateur(Boolean isOrganisateur) {
		this.isOrganisateur = isOrganisateur;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Participation [id=" + id + ", dateInscription=" + dateInscription + ", isOrganisateur=" + isOrganisateur
				+ ", evenement=" + evenement + ", utilisateur=" + utilisateur + "]";
	}
}

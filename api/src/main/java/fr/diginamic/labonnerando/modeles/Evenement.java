package fr.diginamic.labonnerando.modeles;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author BOUDI Elle permet de lister tous les évènements liés à plusieurs
 *         itinéraires et utilisateurs
 *
 */
@Entity
@Table(name = "evenement")
public class Evenement {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	@Column
	private String nom;

	private LocalDate dateEvenement;

	@Column(name = "heure_debut")
	private LocalTime heureDebut;

	@Column(name = "heure_fin")
	private LocalTime heureFin;

	@Column(name = "date_creation")
	@ColumnDefault(value = "(CURDATE())")
	private LocalDateTime dateCreation;

	@Column(name = "date_modification")
	@ColumnDefault(value = "(CURDATE())")
	private LocalDateTime dateModification;

	@ManyToOne(optional = false)
	private Itineraire itineraire;

	@JsonIgnore
	@OneToMany(mappedBy = "evenement")
	private Collection<Participation> participations;

	// Constructor

	// Getters et setters

	public String getNom() {
		return nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public LocalDate getDateEvenement() {
		return dateEvenement;
	}

	public void setDateEvenement(final LocalDate dateEvenement) {
		this.dateEvenement = dateEvenement;
	}

	public LocalTime getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(final LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}

	public LocalTime getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(final LocalTime heureFin) {
		this.heureFin = heureFin;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(final LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDateTime getDateModification() {
		return dateModification;
	}

	public void setDateModification(final LocalDateTime dateModification) {
		this.dateModification = dateModification;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Itineraire getItineraire() {
		return itineraire;
	}

	public void setItineraire(final Itineraire itineraire) {
		this.itineraire = itineraire;
	}

	public Collection<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(final Collection<Participation> participations) {
		this.participations = participations;
	}

	/**
	 * Méthode to string
	 */
	@Override
	public String toString() {
		return "Evenement [id=" + id + ", nom=" + nom + ", dateEvenement=" + dateEvenement + ", heureDebut="
				+ heureDebut + ", heureFin=" + heureFin + ", dateCreation=" + dateCreation + ", dateModification="
				+ dateModification + "]";
	}

}

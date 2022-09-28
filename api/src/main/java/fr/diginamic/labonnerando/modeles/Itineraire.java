package fr.diginamic.labonnerando.modeles;

import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Cette classe représente les itinéraires de randonnée gérés par l'application
 *
 * @author Amin
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Itineraire {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	private Integer idLocal;
	private String producteur;
	private String contact;
	private String uuid;
	private String url;
	private String idOsm;
	private String nomItineraire;
	private String pratique;
	private String typeItineraire;
	private String communesNom;
	private String communesCode;
	private String depart;
	private String arrivee;
	private Integer duree;
	private String balisage;
	private Integer longueur;
	private String difficulte;
	private Integer altitudeMax;
	private Integer altitudeMin;
	private Integer denivelePositif;
	private Integer deniveleNegatif;
	private String instructions;
	private String presentation;
	private String presentationCourte;
	private String themes;
	private String recommendations;
	private String accessibilite;
	private String accesRoutier;
	private String transportsCommun;
	private String parkingInfo;
	private String parkingGeometrie;
	private LocalDateTime dateCreation;
	private LocalDateTime dateModification;
	private String itineraireParent;
	private String typeSol;
	private String pdiprInscription;
	private String pdiprDateInscription;

	/**
	 * le fetchtype peut poser problème si une boucle est generée par association
	 */
	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "itineraire", cascade = REMOVE)
	private Collection<Coordonnees> coordonnees;

	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "itineraire")
	private Collection<Evenement> evenements;
}

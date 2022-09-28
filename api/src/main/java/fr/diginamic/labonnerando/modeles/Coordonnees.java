package fr.diginamic.labonnerando.modeles;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Coordonnees {

	// attributs de la classe coordonnées
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	private Double longitude;

	private Double latitude;

	@JsonIgnore
	@ManyToOne(optional = false)
	private Itineraire itineraire;

	// constructor

	// getters et setters

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(final Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(final Double latitude) {
		this.latitude = latitude;
	}

	public Itineraire getItineraire() {
		return itineraire;
	}

	public void setItineraire(final Itineraire itineraire) {
		this.itineraire = itineraire;
	}
}

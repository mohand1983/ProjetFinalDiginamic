package fr.diginamic.labonnerando.modeles;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Gontran
 *
 */
@Entity
public class PointInteret {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	@Column(name = "libelle")
	private String libelle;

	@JsonIgnore
	@ManyToMany(mappedBy = "pointsInterets")
	private Collection<Utilisateur> utilisateurs;

	// Constructor

	/**
	 *
	 */
	public PointInteret() {
	}

	/**
	 *
	 * @param libelle
	 */
	public PointInteret(final String libelle) {
		this.libelle = libelle;
	}

	// Getters & Setters

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(final String libelle) {
		this.libelle = libelle;
	}

	// Methode tout string

	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(final Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@Override
	public String toString() {
		return "PointInteret [id=" + id + ", libelle=" + libelle + "]";
	}

}

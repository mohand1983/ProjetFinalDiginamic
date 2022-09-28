package fr.diginamic.labonnerando.modeles;

import static fr.diginamic.labonnerando.enums.Role.UTILISATEUR;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.diginamic.labonnerando.enums.Role;

/**
 *
 * @author Veronique
 *
 */

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	private String password;

	@NotNull
	@Length(max = 64)
	private String nom;

	@NotNull
	@Length(max = 64)
	private String prenom;

	@NotNull
	@Column(unique = true)
	private String email;

	@NotNull
	@Length(max = 20)
	private String telephone;

	@Enumerated(STRING)
	private Role role = UTILISATEUR;

	@Column(name = "date_creation")
	@ColumnDefault(value = "(CURDATE())")
	private LocalDateTime dateCreation;

	@Column(name = "date_modification")
	@ColumnDefault(value = "(CURDATE())")
	private LocalDateTime dateModification;

	@JsonIgnore
	@OneToMany(mappedBy = "utilisateur")
	private Collection<Participation> participations;

	/**
	 * liste des points d'intérêts
	 *
	 * Le join table sert à specifier le nom de la table et des colonnes générés et
	 * gérés par Hibernate
	 */
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "points_interets_utilisateurs", joinColumns = @JoinColumn(name = "id_utilisateur", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_point_interet", referencedColumnName = "id"))
	private Collection<PointInteret> pointsInterets;

	// Constructeur

	// Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(final String telephone) {
		this.telephone = telephone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(final Role role) {
		this.role = role;
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

	public Collection<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(final Collection<Participation> participations) {
		this.participations = participations;
	}

	public Collection<PointInteret> getPointsInterets() {
		return pointsInterets;
	}

	public void setPointsInterets(final Collection<PointInteret> pointsInterets) {
		this.pointsInterets = pointsInterets;
	}

	// Redefinition tostring, equals, hashcode

	@Override
	public String toString() {
		final var builder = new StringBuilder();
		builder.append("Utilisateur [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (password != null)
			builder.append("password=").append(password).append(", ");
		if (nom != null)
			builder.append("nom=").append(nom).append(", ");
		if (prenom != null)
			builder.append("prenom=").append(prenom).append(", ");
		if (email != null)
			builder.append("email=").append(email).append(", ");
		if (telephone != null)
			builder.append("telephone=").append(telephone).append(", ");
		if (role != null)
			builder.append("role=").append(role).append(", ");
		if (dateCreation != null)
			builder.append("dateCreation=").append(dateCreation).append(", ");
		if (dateModification != null)
			builder.append("dateModification=").append(dateModification).append(", ");
		if (participations != null)
			builder.append("participations=").append(participations).append(", ");
		if (pointsInterets != null)
			builder.append("pointsInterets=").append(pointsInterets);
		builder.append("]");
		return builder.toString();
	}
}

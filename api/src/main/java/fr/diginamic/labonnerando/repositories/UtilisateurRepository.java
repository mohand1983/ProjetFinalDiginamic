package fr.diginamic.labonnerando.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import fr.diginamic.labonnerando.modeles.Utilisateur;

/**
 *
 * @author Veronique
 *
 */

@Repository
public interface UtilisateurRepository extends JpaRepositoryImplementation<Utilisateur, Integer> {

	Optional<Utilisateur> findByEmail(String email);
}

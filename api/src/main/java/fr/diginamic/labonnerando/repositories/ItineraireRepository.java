package fr.diginamic.labonnerando.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import fr.diginamic.labonnerando.modeles.Itineraire;

/**
 *
 * @author Riwan
 *
 */
@Repository
public interface ItineraireRepository extends JpaRepositoryImplementation<Itineraire, Integer> {

}

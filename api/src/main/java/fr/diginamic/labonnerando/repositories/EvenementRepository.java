package fr.diginamic.labonnerando.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import fr.diginamic.labonnerando.modeles.Evenement;

/**
 *
 * @author BOUDI
 *
 */
@Repository
public interface EvenementRepository extends JpaRepositoryImplementation<Evenement, Integer> {

}

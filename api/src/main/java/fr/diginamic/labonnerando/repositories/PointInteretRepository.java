package fr.diginamic.labonnerando.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import fr.diginamic.labonnerando.modeles.PointInteret;

/**
 *
 * @author Gontran
 *
 */
@Repository
public interface PointInteretRepository extends JpaRepositoryImplementation<PointInteret, Integer> {

}

package fr.diginamic.labonnerando.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import fr.diginamic.labonnerando.modeles.Participation;

@Repository
public interface ParticipationRepository extends JpaRepositoryImplementation<Participation, Integer> {

}

package fr.diginamic.labonnerando.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.diginamic.labonnerando.modeles.Participation;
import fr.diginamic.labonnerando.repositories.ParticipationRepository;

@Service
public class ParticipationService {

	@Autowired
	private ParticipationRepository participationRepository;

	public ParticipationService(ParticipationRepository mockedRepo) {
		this.participationRepository = mockedRepo;
	}

	public Collection<Participation> findAll() {
		return this.participationRepository.findAll();
	}

	public Page<Participation> findPage(Integer numeroDePage, Integer nombreParticipation) {
		return this.participationRepository.findAll(PageRequest.of(numeroDePage, nombreParticipation));
	}

	public Page<Participation> findMatching(Participation itineraire, Integer numeroDePage,
			Integer nombreParticipation) {
		return this.participationRepository.findAll(Example.of(itineraire),
				PageRequest.of(numeroDePage, nombreParticipation));
	}
}

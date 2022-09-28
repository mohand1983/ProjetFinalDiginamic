package fr.diginamic.labonnerando.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.diginamic.labonnerando.modeles.Evenement;
import fr.diginamic.labonnerando.repositories.EvenementRepository;

@Service
public class EvenementService {

	@Autowired
	private EvenementRepository evenementRepository;

	/**
	 * 
	 * @return La méthode findAll une passe plat vers la méthode du répository
	 */
	public Collection<Evenement> findAll() {
		return this.evenementRepository.findAll();
	}

	public Page<Evenement> findPage(Integer numeroDePage, Integer nombreEvenement) {
		return this.evenementRepository.findAll(PageRequest.of(numeroDePage, nombreEvenement));
	}

	public Page<Evenement> findMatching(Evenement evenement, Integer numeroDePage, Integer nombreEvenement) {
		return this.evenementRepository.findAll(Example.of(evenement), PageRequest.of(numeroDePage, nombreEvenement));
	}
}

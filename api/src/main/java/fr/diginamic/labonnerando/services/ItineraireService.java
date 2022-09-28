package fr.diginamic.labonnerando.services;

import static org.springframework.data.domain.ExampleMatcher.StringMatcher.CONTAINING;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.diginamic.labonnerando.modeles.Itineraire;
import fr.diginamic.labonnerando.repositories.ItineraireRepository;
import fr.diginamic.labonnerando.wrappers.Filter;

/**
 *
 * @author Riwan
 *
 */
@Service
public class ItineraireService {

	@Autowired
	private final ItineraireRepository itineraireRepository;

	public ItineraireService(final ItineraireRepository mockedRepo) {
		itineraireRepository = mockedRepo;
	}

	public Collection<Itineraire> findAll() {
		return itineraireRepository.findAll();
	}

	public Page<Itineraire> findPage(final Integer page, final Integer size) {
		return itineraireRepository.findAll(PageRequest.of(page, size));
	}

	public Page<Itineraire> findMatching(final Itineraire itineraire, final Integer page, final Integer size) {
		return itineraireRepository.findAll(Example.of(itineraire),
				PageRequest.of(page, size));
	}

	public Itineraire findById(final Integer id) {
		return itineraireRepository.findById(id).orElseThrow();
	}

	/**
	 * TODO add filtering using all of the fields in filtre
	 *
	 * @param filtre
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Itineraire> findFilteredPage(final Filter<Itineraire> filtre, final Integer page, final Integer size) {
		return itineraireRepository.findAll(
				Example.of(
						filtre.getSubject(),
						ExampleMatcher.matching()
								.withIgnoreCase()
								.withStringMatcher(CONTAINING)),
				PageRequest.of(page, size));
	}
}

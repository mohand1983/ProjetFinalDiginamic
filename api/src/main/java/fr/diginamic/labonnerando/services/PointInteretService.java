package fr.diginamic.labonnerando.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.diginamic.labonnerando.modeles.PointInteret;
import fr.diginamic.labonnerando.repositories.PointInteretRepository;

/**
 * 
 * @author Alfred
 * 
 */
@Service
public class PointInteretService {

	@Autowired
	private PointInteretRepository pointInteretRepository;

	/**
	 * 
	 * @return La méthode findAll une passe plat vers la méthode du répository
	 */

	public Collection<PointInteret> findAll() {
		return this.pointInteretRepository.findAll();
	}

	public Page<PointInteret> findPage(Integer numeroDePage, Integer nombrePointInteret) {
		return this.pointInteretRepository.findAll(PageRequest.of(numeroDePage, nombrePointInteret));
	}

	public Page<PointInteret> findMatching(PointInteret pointInteret, Integer numeroDePage,
			Integer nombrePointInteret) {
		return this.pointInteretRepository.findAll(Example.of(pointInteret),
				PageRequest.of(numeroDePage, nombrePointInteret));
	}
}

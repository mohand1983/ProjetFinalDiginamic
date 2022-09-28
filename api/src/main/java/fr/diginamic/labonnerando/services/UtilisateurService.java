package fr.diginamic.labonnerando.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.diginamic.labonnerando.modeles.Utilisateur;
import fr.diginamic.labonnerando.repositories.UtilisateurRepository;

/**
 * 
 * @author Veronique
 *
 */

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	public UtilisateurService(UtilisateurRepository mockedRepo) {
		this.utilisateurRepo = mockedRepo;
	}

	public Collection<Utilisateur> findAll() {
		return this.utilisateurRepo.findAll();
	}

	public Page<Utilisateur> findPage(Integer numeroDePage, Integer nombreUtilisateur) {
		return this.utilisateurRepo.findAll(PageRequest.of(numeroDePage, nombreUtilisateur));
	}

	public Page<Utilisateur> findMatching(Utilisateur utilisateur, Integer numeroDePage, Integer nombreUtilisateur) {
		return this.utilisateurRepo.findAll(Example.of(utilisateur), PageRequest.of(numeroDePage, nombreUtilisateur));
	}
}

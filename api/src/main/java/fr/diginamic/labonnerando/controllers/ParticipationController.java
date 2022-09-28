package fr.diginamic.labonnerando.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.labonnerando.modeles.Participation;
import fr.diginamic.labonnerando.services.ParticipationService;

@RestController
@RequestMapping("/api/participation")
@CrossOrigin("http://localhost:4200")
public class ParticipationController {
	@Autowired
	private ParticipationService participationService;

	/**
	 * 
	 * @return La liste de toutes les participations présentes en base de données
	 */
	@GetMapping
	public Collection<Participation> findAll() {
		return this.participationService.findAll();
	}

	@GetMapping("/page")
	public Page<Participation> findPage(@RequestParam(name = "page", value = "0") Integer numeroPage,
			@RequestParam(name = "size", value = "10") Integer nombreParticipation) {

		return this.participationService.findPage(numeroPage, nombreParticipation);
	}

	@PostMapping("/matching")
	public Page<Participation> findMatching(@RequestBody Participation participation,
			@RequestParam(name = "page", value = "0") Integer numeroPage,
			@RequestParam(name = "size", value = "10") Integer nombreParticipation) {

		return this.participationService.findMatching(participation, numeroPage, nombreParticipation);
	}
}

package fr.diginamic.labonnerando.services;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.diginamic.labonnerando.modeles.Itineraire;
import fr.diginamic.labonnerando.repositories.ItineraireRepository;

@ExtendWith(MockitoExtension.class)
class ItineraireServiceTest {

	private ItineraireService serviceUnderTest;

	@Mock
	private ItineraireRepository mockedRepository;

	@BeforeEach
	void setUp() throws Exception {

		serviceUnderTest = new ItineraireService(mockedRepository);

		mockedRepository.saveAll(Arrays.asList(
				Itineraire.builder().pdiprDateInscription("test").accessibilite("parking").build(),
				Itineraire.builder().altitudeMax(50).arrivee("montpellier").build(),
				Itineraire.builder().contact("ally").dateCreation(LocalDateTime.now()).build()));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void doitRenvoyerTousLesItineraires() {
		// etant donné

		// quand
		final var listItineraires = serviceUnderTest.findAll();

		// alors
		Assertions.assertThat(listItineraires).isNotNull();
	}

	@Test
	void doitCorrespondreALaPageEtAuNombre() {
		// etant donné
		final var numeroPage = 2;
		final var nombreItineraire = 1;

		// quand
		final var pageItineraires = serviceUnderTest.findPage(numeroPage, nombreItineraire);

		// alors
		Assertions.assertThat(pageItineraires.getNumber()).isEqualTo(numeroPage);
		Assertions.assertThat(pageItineraires.getSize()).isEqualTo(nombreItineraire);
	}

	@Test
	@Disabled
	void testFindMatching() {
	}

}

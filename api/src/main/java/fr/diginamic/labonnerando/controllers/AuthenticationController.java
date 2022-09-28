package fr.diginamic.labonnerando.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.labonnerando.services.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class AuthenticationController {

	private AuthenticationService authService;

}

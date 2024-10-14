package br.itb.projeto.sosmecanica.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.sosmecanica.model.entity.AvalMecanico;
import br.itb.projeto.sosmecanica.rest.exception.ResourceNotFoundException;
import br.itb.projeto.sosmecanica.service.AvalMecanicoService;


@RestController
@RequestMapping("/AvalMecanico/")
public class AvalMecanicoController {

	private AvalMecanicoService avalMecanicoService;

	public AvalMecanicoController(AvalMecanicoService avalMecanicoService) {
		super();
		this.avalMecanicoService = avalMecanicoService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<AvalMecanico>> findAll() {
		List<AvalMecanico> avalAvalMecanicos = avalMecanicoService.findAll();

		return new ResponseEntity<List<AvalMecanico>>(avalAvalMecanicos, HttpStatus.OK);
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<AvalMecanico> findById(@PathVariable long id) {

		AvalMecanico avalMecanico = avalMecanicoService.findById(id);

		if (avalMecanico != null) {
			return new ResponseEntity<AvalMecanico>(avalMecanico, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("*** AvalMecanico não encontrado! *** " + "ID: " + id);
		}

	}

}

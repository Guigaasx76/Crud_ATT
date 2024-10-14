package br.itb.projeto.sosmecanica.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.sosmecanica.model.entity.Mecanico;
import br.itb.projeto.sosmecanica.model.entity.Mecanico;
import br.itb.projeto.sosmecanica.model.repository.MecanicoRepository;
import br.itb.projeto.sosmecanica.rest.exception.ResourceNotFoundException;
import br.itb.projeto.sosmecanica.service.MecanicoService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/mecanico/")
public class MecanicoController {

    private final MecanicoService mecanicoService;

    public MecanicoController(MecanicoService mecanicoService) {
		super();
		this.mecanicoService = mecanicoService;
	}

    @GetMapping("findAll")
	public ResponseEntity<List<Mecanico>> findAll() {
		List<Mecanico> mensagens = mecanicoService.findAll();

		return new ResponseEntity<List<Mecanico>>(mensagens, HttpStatus.OK);
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<Mecanico> findById(@PathVariable long id) {

		Mecanico mecanico = mecanicoService.findById(id);

		if (mecanico != null) {
			return new ResponseEntity<Mecanico>(mecanico, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("*** Mecanico não encontrada! *** " + "ID: " + id);
		}

	}
	

   
}

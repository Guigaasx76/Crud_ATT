package br.itb.projeto.sosmecanica.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.itb.projeto.sosmecanica.model.entity.Mecanico;
import br.itb.projeto.sosmecanica.rest.exception.ResourceNotFoundException;
import br.itb.projeto.sosmecanica.rest.response.MessageResponse;
import br.itb.projeto.sosmecanica.service.MecanicoService;

@RestController
@RequestMapping("/mecanico/")
public class MecanicoController {

	private MecanicoService mecanicoService;

	public MecanicoController(MecanicoService mecanicoService) {
		super();
		this.mecanicoService = mecanicoService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Mecanico>> findAll() {
		List<Mecanico> mecanicos = mecanicoService.findAll();

		return new ResponseEntity<List<Mecanico>>(mecanicos, HttpStatus.OK);
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<Mecanico> findById(@PathVariable long id) {

		Mecanico mecanico = mecanicoService.findById(id);

		if (mecanico != null) {
			return new ResponseEntity<Mecanico>(mecanico, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("*** Mecanico não encontrado! *** " + "ID: " + id);
		}

	}
	
	@PostMapping("create")
	public ResponseEntity<?> create(@RequestBody Mecanico mecanico) {

		Mecanico _mecanico = mecanicoService.create(mecanico);

		if (_mecanico == null) {
			return ResponseEntity.badRequest().body(
					new MessageResponse("Mecanico já cadastrado!"));
		}
		return ResponseEntity.ok()
				.body(new MessageResponse("Mecanico cadastrado com sucesso!"));
	}
		
	
	@PutMapping("inativar/{id}")
	public ResponseEntity<Mecanico> inativar(@PathVariable long id) {

		Mecanico _mecanico = mecanicoService.inativar(id);

		return new ResponseEntity<Mecanico>(_mecanico, HttpStatus.OK);
	}

	@PutMapping("reativar/{id}")
	public ResponseEntity<Mecanico> reativar(@PathVariable long id) {

		Mecanico _mecanico = mecanicoService.reativar(id);

		return new ResponseEntity<Mecanico>(_mecanico, HttpStatus.OK);
	}


}

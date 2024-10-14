package br.itb.projeto.sosmecanica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.sosmecanica.model.entity.AvalMecanico;
import br.itb.projeto.sosmecanica.model.entity.Usuario;
import br.itb.projeto.sosmecanica.model.repository.AvalMecanicoRepository;
import jakarta.transaction.Transactional;

@Service
public class AvalMecanicoService {

	private AvalMecanicoRepository avalMecanicoRepository;

	public AvalMecanicoService(AvalMecanicoRepository avalMecanicoRepository) {
		super();
		this.avalMecanicoRepository = avalMecanicoRepository;
	}
	
	public List<AvalMecanico> findAll(){
		List<AvalMecanico> avalMecanicos = avalMecanicoRepository.findAll();
		return avalMecanicos;
	}
	
	@Transactional
	public AvalMecanico create(AvalMecanico avalMecanico) {
		
		return avalMecanicoRepository.save(avalMecanico);
	}

	public AvalMecanico findById(long id) {

		Optional<AvalMecanico> avalMecanico = avalMecanicoRepository.findById(id);

		if (avalMecanico.isPresent()) {
			return avalMecanico.get();
		}

		return null;
	}

}

package br.itb.projeto.sosmecanica.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.itb.projeto.sosmecanica.model.entity.Mecanico;
import br.itb.projeto.sosmecanica.model.entity.Mensagem;
import br.itb.projeto.sosmecanica.model.repository.MecanicoRepository;
import jakarta.transaction.Transactional;

@Service
public class MecanicoService {

	private MecanicoRepository mecanicoRepository;

	public MecanicoService(MecanicoRepository mecanicoRepository) {
		super();
		this.mecanicoRepository = mecanicoRepository;
	}
	
	public List<Mecanico> findAll(){
		List<Mecanico> mecanicos = mecanicoRepository.findAll();
		return mecanicos;
	}
	
	public Mecanico findById(long id) {

		Optional<Mecanico> mecanico = mecanicoRepository.findById(id);

		if (mecanico.isPresent()) {
			return mecanico.get();
		}

		return null;
	}

	@Transactional
	public Mecanico create(Mecanico mecanico) {
	
		mecanico.setStatusMecanico("ATIVO");
		
		return mecanicoRepository.save(mecanico);
	}
	
	
	
	@Transactional
	public Mecanico inativar(long id) {
		Optional<Mecanico> _mecanico = 
				mecanicoRepository.findById(id);
		
		if (_mecanico.isPresent()) {
			Mecanico mecanicoAtualizado = _mecanico.get();
			mecanicoAtualizado.setStatusMecanico("INATIVO");
			
			return mecanicoRepository.save(mecanicoAtualizado);
		}
		return null;
	}
	
	@Transactional
	public Mecanico reativar(long id) {
		Optional<Mecanico> _mecanico = 
				mecanicoRepository.findById(id);
		
		if (_mecanico.isPresent()) {
			Mecanico mecanicoAtualizado = _mecanico.get();
		
			mecanicoAtualizado.setStatusMecanico("ATIVO");
			
			return mecanicoRepository.save(mecanicoAtualizado);
		}
		return null;
	}
	
	@Transactional
	public Mecanico alterar(long id, Mecanico mecanico) {
		Optional<Mecanico> _mecanico = 
				mecanicoRepository.findById(id);
		
		if (_mecanico.isPresent()) {
			Mecanico mecanicoAtualizado = _mecanico.get();
			
			mecanicoAtualizado.setTelefone(mecanico.getTelefone());
			mecanicoAtualizado.setNome(mecanico.getNome());
			mecanicoAtualizado.setCidade(mecanico.getCidade());
			mecanicoAtualizado.setDescricao(mecanico.getDescricao());
			
			
			return mecanicoRepository.save(mecanicoAtualizado);
		}
		return null;
	}
}

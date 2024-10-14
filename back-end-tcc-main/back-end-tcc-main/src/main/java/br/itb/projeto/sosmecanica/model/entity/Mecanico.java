package br.itb.projeto.sosmecanica.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Mecanico")
public class Mecanico {

	@Id
	@GeneratedValue
		(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome; 
	private String telefone; 
	private String cpf;
	private String cidade; 
	private String descricao; 
	
	
	
	
		


	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	private String statusMecanico;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getStatusMecanico() {
		return statusMecanico;
	}

	public void setStatusMecanico(String statusMecanico) {
		this.statusMecanico = statusMecanico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
	
	
}

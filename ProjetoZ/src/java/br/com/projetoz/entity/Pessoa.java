package br.com.projetoz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.projetoz.generic.entity.ItfEntidade;

@Entity
@Table(name="pessoa")
public class Pessoa implements ItfEntidade{

	@Id
	@Column(name = "ID_PESSOA")
	@GeneratedValue
	private Long id;
	
	@Column(name="DS_NOME", nullable=true, length=60)
	private String nome;
	
	@Column(name="NR_CPF", nullable=true, length=14)
	private String cpf;

	
	public Pessoa(){
	}
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}

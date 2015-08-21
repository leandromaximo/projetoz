package br.com.projetoz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pessoa")
public class Pessoa{

	@Id
	@Column(name = "ID_PESSOA")
	@GeneratedValue
	private Integer id;
	
	@Column(name="DS_NOME", nullable=true, length=60)
	private String nome;
	
	@Column(name="NR_CPF", nullable=true, length=11)
	private Integer cpf;
	
	public Pessoa() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

}

package br.com.projetoz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.projetoz.entity.generic.ItfEntidade;

@Entity
@Table(name="PESSOA")
public class Pessoa implements ItfEntidade{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PESSOA")
	@GeneratedValue
	private Long id;
	
	@OneToMany
	@Column(name = "ID_PESSOA_FISICA")
	private PessoaFisica pessoaFisica;
	
	@OneToMany
	@Column(name = "ID_PESSOA_JURIDICA")
	private PessoaJuridica pessoaJuridica;

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

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
}

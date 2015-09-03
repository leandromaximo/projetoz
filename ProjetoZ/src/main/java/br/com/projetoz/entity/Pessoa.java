package br.com.projetoz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

import br.com.projetoz.entity.generic.ItfEntidade;

@Entity
@Table(name="PESSOA")
public class Pessoa implements ItfEntidade{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PESSOA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "ID_PESSOA_FISICA", nullable=true)
	@OneToOne(fetch=FetchType.LAZY)
	private PessoaFisica pessoaFisica;
	
	@JoinColumn(name = "ID_PESSOA_JURIDICA", nullable=true)
	@OneToOne(fetch=FetchType.LAZY)
	private PessoaJuridica pessoaJuridica;
	
	@NotNull
	@JoinColumn(name = "ID_MUNICIPIO", nullable=true)
	@OneToOne(fetch=FetchType.LAZY)
	private Municipio municipio;

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

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
}

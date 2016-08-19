package br.com.projetoz.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.projetoz.entity.generic.ItfEntidade;

@Entity
@Table(name="PAIS")
public class Pais implements ItfEntidade{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PAIS")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="CODIGO_PAIS", nullable=true, length=5)
	private Long codigoUf;
	
	@Column(name="DS_NOME", nullable=true, length=60)
	private String nome;
	
	@Column(name="DS_SIGLA", nullable=true, length=2)
	private String sigla;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "pais")
	private Collection<Uf> listUf;
	
	public Pais(){
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCodigoUf() {
		return codigoUf;
	}

	public void setCodigoUf(Long codigoUf) {
		this.codigoUf = codigoUf;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Collection<Uf> getListUf() {
		return listUf;
	}

	public void setListUf(Collection<Uf> listUf) {
		this.listUf = listUf;
	}

}

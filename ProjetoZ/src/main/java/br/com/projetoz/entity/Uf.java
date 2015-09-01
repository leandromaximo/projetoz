package br.com.projetoz.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.projetoz.entity.generic.ItfEntidade;

@Entity
@Table(name="UF")
public class Uf implements ItfEntidade{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_UF")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="CODIGO_UF", nullable=true, length=2)
	private Long codigoUf;
	
	@Column(name="DS_NOME", nullable=true, length=60)
	private String nome;
	
	@Column(name="DS_SIGLA", nullable=true, length=60)
	private String sigla;
	
	@JoinColumn(name = "ID_REGIAO", nullable=true)
	@ManyToOne(fetch=FetchType.LAZY)
	private Regiao regiao;
	
	@JoinColumn(name = "ID_PAIS", nullable=true)
	@ManyToOne(fetch=FetchType.LAZY)
	private Pais pais;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "uf")
	private Collection<Municipio> listMunicipio;
	
	public Uf(){
		
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigoUf() {
		return codigoUf;
	}

	public void setCodigoUf(Long codigoUf) {
		this.codigoUf = codigoUf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Collection<Municipio> getListMunicipio() {
		return listMunicipio;
	}

	public void setListMunicipio(Collection<Municipio> listMunicipio) {
		this.listMunicipio = listMunicipio;
	}

}

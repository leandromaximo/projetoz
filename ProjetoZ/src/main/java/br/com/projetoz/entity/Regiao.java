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
@Table(name="REGIAO")
public class Regiao implements ItfEntidade{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_REGIAO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="DS_NOME", nullable=true, length=60)
	private String nome;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "regiao")
	private Collection<Uf> listUf;
	
	public Regiao(){
		
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

	public Collection<Uf> getListUf() {
		return listUf;
	}

	public void setListUf(Collection<Uf> listUf) {
		this.listUf = listUf;
	}

}

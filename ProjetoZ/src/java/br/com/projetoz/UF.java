package br.com.projetoz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uf")
public class UF{
	private static final long serialVersionUID = 1L;
	/**************************************************************************/
	/**                             ATRIBUTOS                                **/
	/**************************************************************************/

	@Id
	@Column(name = "id_uf")
	private Integer id;
	
	@Column(name="ds_nome", nullable=false, length=60)
	private String nome;
	
	@Column(name="ds_sigla", nullable=false, length=2)
	private String sigla;
	
	public UF() {
	}
	
	public UF(Integer id) {
		this.id = id;
	}
	
	/********************************************************************/
	/** 															   **/
	/**                       RELACIONAMENTOS         				   **/
	/**															 	   **/
	/********************************************************************/
	
	/**************************************************************************/
	/**                              GET's E SET's                           **/
	/**************************************************************************/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/********************************************************************/
	/**                EQUALS E HASH CODE  - RETIRAR LIST's            **/
	/********************************************************************/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UF other = (UF) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}
	
}

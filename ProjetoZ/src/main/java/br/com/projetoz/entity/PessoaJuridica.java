package br.com.projetoz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.projetoz.entity.generic.ItfEntidade;

@Entity
@Table(name="PESSOA_JURIDICA")
public class PessoaJuridica implements ItfEntidade{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PESSOA_JURIDICA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="DS_RAZAO_SOCIAL", nullable=true, length=60)
	private String razaoSocial;
	
	@Column(name="NR_CNPJ", nullable=true, length=14)
	private String cnpj;
	
	public PessoaJuridica(){
		
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


}

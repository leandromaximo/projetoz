package br.com.projetoz.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetoz.entity.Pessoa;
import br.com.projetoz.entity.PessoaFisica;
import br.com.projetoz.entity.PessoaJuridica;
import br.com.projetoz.service.PessoaService;

@Named
@ConversationScoped
public class PessoaMB implements Serializable {

	private static final long serialVersionUID = 4771270804699990999L;
	
	@Inject
    private Conversation conversation;
	
	@Inject 
	PessoaService pessoaService;
	
	Collection<Pessoa> listPessoa = new ArrayList<Pessoa>();
	Pessoa pessoa = new Pessoa();
	PessoaFisica pessoaFisica = new PessoaFisica();
	PessoaJuridica pessoaJuridica = new PessoaJuridica();
	
	@PostConstruct
	public void init(){
		listPessoa  = pessoaService.outraRegraDeNegocioEspecificaBuscar(null);
	}
	
	public void initConversation(){
		if (!FacesContext.getCurrentInstance().isPostback() 
			&& conversation.isTransient()) {
			conversation.begin();
		}
	}
	
	public String endConversation(){
		if(!conversation.isTransient()){
			conversation.end();
		}
		return "home?faces-redirect=true";
	}
	
	public String salvar() {
		pessoa.setPessoaFisica(pessoaFisica);
		pessoaService.regraDeNegocioAqui(pessoa);
		return "pesquisarPessoa?faces-redirect=true";
	}

	public Conversation getConversation() {
		return conversation;
	}

	public Collection<Pessoa> getListPessoa() {
		return listPessoa;
	}

	public void setListPessoa(Collection<Pessoa> listPessoa) {
		this.listPessoa = listPessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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

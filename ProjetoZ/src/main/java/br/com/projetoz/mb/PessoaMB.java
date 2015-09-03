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

	public Conversation getConversation() {
		return conversation;
	}

	public Collection<Pessoa> getListPessoa() {
		return listPessoa;
	}

	public void setListPessoa(Collection<Pessoa> listPessoa) {
		this.listPessoa = listPessoa;
	}
	
}

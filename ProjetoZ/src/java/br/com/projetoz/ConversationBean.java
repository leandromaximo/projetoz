package br.com.projetoz;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Named
@ConversationScoped
public class ConversationBean implements Serializable {

	private static final long serialVersionUID = 4771270804699990999L;
	
	@Inject
    private Conversation conversation;
	
	private int counter;
	
	// Will only be called once
	// during bean initialization
	@PostConstruct
	public void init(){
		counter = 0;
	}
	
	public void teste(){
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("projetoZPU");

		/* Create and populate Entity */
		

		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();

		/* Persist entity */
		
		em.getTransaction().begin();
		Query q = em.createQuery("from Pessoa");
		List<Pessoa> list = q.getResultList();
		for (Pessoa pessoa : list) {
			System.out.println(pessoa.getNome());
		}
		
		em.close();
	}
	
	
	
	public void initConversation(){
		if (!FacesContext.getCurrentInstance().isPostback() 
			&& conversation.isTransient()) {
			
			conversation.begin();
		}
		teste();
	}
	
	public void increment(){
		counter++;
	}
	
	public String handleFirstStepSubmit(){
		return "step2?faces-redirect=true";
	}
	
	public String endConversation(){
		if(!conversation.isTransient()){
			conversation.end();
		}
		return "step1?faces-redirect=true";
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Conversation getConversation() {
		return conversation;
	}
	
}

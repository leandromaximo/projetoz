package br.com.projetoz.generic.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.projetoz.util.Constantes;

public class EntityManagerCreator {
	private static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory(Constantes.PERSISTENCE_UNIT);

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager entityManager) {
		entityManager.close();
	}

}

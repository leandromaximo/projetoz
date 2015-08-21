package br.com.projetoz.generic.dao;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.criterion.Order;


@SuppressWarnings(value = { "unchecked","rawtypes" })
public abstract class AbstDAO{
	
	@Inject
	protected EntityManager entityManager;

	public EntityManager getEntityManager(){
		return entityManager;
	}

	public void incluir(Object entidade){
		entityManager.persist(entidade); 
	}

	public void alterar(Object entidade){
		entityManager.merge(entidade); 
	}

	public <E> E saveOrUpdate(E entidade){
		return entityManager.merge(entidade);
	}
	
	public void excluir(Object entidade){
		entidade = entityManager.merge(entidade);
		entityManager.remove(entidade);
	}
	
	public <E> Collection<E> findAll(Class<E> entityClass){
		return entityManager.createQuery("from "+entityClass.getSimpleName()).getResultList();
	}
	
	public <E> Collection<E> findAll(Class<E> entityClass,Order orderBy){
		return entityManager.createQuery("from "+entityClass.getSimpleName() + " order by "+orderBy.toString()).getResultList();
	}
	
//	public Collection<T> findAllByProperty(String propriedade,Object valor){
//		StringBuilder sql = new StringBuilder("from ")
//		.append(entityClass.getSimpleName())
//		.append(" where ")
//		.append(propriedade)
//		.append(" = :valor");
//		Query q = entityManager.createQuery(sql.toString());
//		q.setParameter("valor", valor);
//		return q.getResultList();
//	}
//	
//	public Collection<T> findAllByProperty(String propriedade,Object valor,Order orderBy){
//		StringBuilder sql = new StringBuilder("from ")
//		.append(entityClass.getSimpleName())
//		.append(" where ")
//		.append(propriedade)
//		.append(" = :valor ")
//		.append("order by " + orderBy.toString());
//		Query q = entityManager.createQuery(sql.toString());
//		q.setParameter("valor", valor);
//		return q.getResultList();
//	}
//	
//	public T findByProperty(String propriedade,Object valor){
//		StringBuilder sql = new StringBuilder("from ")
//		.append(entityClass.getSimpleName())
//		.append(" where ")
//		.append(propriedade)
//		.append(" = :valor");
//		Query q = entityManager.createQuery(sql.toString());
//		q.setParameter("valor", valor);
//		List result = q.getResultList();
//		if (!result.isEmpty()){
//			return (T) result.get(0);
//		}
//		return null;
//	}
//	
//	public <E> E findByProperty(Class<E> entityClass,String propriedade,Object valor){
//		StringBuilder sql = new StringBuilder("from ")
//		.append(entityClass.getSimpleName())
//		.append(" where ")
//		.append(propriedade)
//		.append(" = :valor");
//		Query q = entityManager.createQuery(sql.toString());
//		q.setParameter("valor", valor);
//		List result = q.getResultList();
//		if (!result.isEmpty()){
//			return (E) result.get(0);
//		}
//		return null;
//	}
//	
//	public <E> Collection<E> findAllByProperty(Class<E> entityClass, String propriedade,Object valor){
//		StringBuilder sql = new StringBuilder("from ")
//		.append(entityClass.getSimpleName())
//		.append(" where ")
//		.append(propriedade)
//		.append(" = :valor");
//		Query q = entityManager.createQuery(sql.toString());
//		q.setParameter("valor", valor);
//		return q.getResultList();
//	}
//	
//	public <E> Collection<E> findAllByProperty(Class<E> entityClass, String propriedade,Object valor,Order orderBy){
//		StringBuilder sql = new StringBuilder("from ")
//		.append(entityClass.getSimpleName())
//		.append(" where ")
//		.append(propriedade)
//		.append(" = :valor")
//		.append(" order by "+orderBy.toString());
//		
//		Query q = entityManager.createQuery(sql.toString());
//		q.setParameter("valor", valor);
//		return q.getResultList();
//	}
//
//	public void removeAll(Class<?> class1, String param,
//			Object paramValue) {
//		Query q = entityManager.createQuery("delete from "+class1.getSimpleName()+" where "+param+" = :param");
//		q.setParameter("param", paramValue);
//		q.executeUpdate();
//	}
	
	public <E> E find(Class<E> classe, Object pk){
		return entityManager.find(classe, pk);
	}
	
	public void flush(){
		entityManager.flush();
	}
	
	public void refresh(Object obj){
		entityManager.refresh(obj);
	}
	
	public void clear(){
		entityManager.clear();
	}
}

package br.com.projetoz.dao;

import java.util.Collection;

import javax.persistence.Query;

import br.com.projetoz.dao.generic.AbstDAO;
import br.com.projetoz.entity.Pessoa;

public class PessoaDAO extends AbstDAO{

	public Collection<Pessoa> aquiUmaQuerieEspecifica(String propriedade,Object valor){
	StringBuilder sql = new StringBuilder("from Pessoa");
	
	Query q = getEntityManager().createQuery(sql.toString());
	
	return q.getResultList();
}
	
	
}

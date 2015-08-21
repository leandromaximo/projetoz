package br.com.projetoz.dao;

import java.util.Collection;

import javax.persistence.Query;

import br.com.projetoz.entity.Pessoa;
import br.com.projetoz.generic.dao.AbstDAO;

public class PessoaDAO extends AbstDAO{

	public Collection<Pessoa> aquiUmaQuerieEspecifica(String propriedade,Object valor){
	StringBuilder sql = new StringBuilder("from Pessoa");
	
	Query q = getEntityManager().createQuery(sql.toString());
	
	return q.getResultList();
}
	
	
}

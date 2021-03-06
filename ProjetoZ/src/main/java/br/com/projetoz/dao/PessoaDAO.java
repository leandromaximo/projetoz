package br.com.projetoz.dao;

import java.util.Collection;

import javax.persistence.Query;

import br.com.projetoz.entity.Pessoa;
import br.com.projetoz.generic.dao.AbstDAO;

public class PessoaDAO extends AbstDAO {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public Collection<Pessoa> aquiUmaQuerieEspecifica(String propriedade, Object valor) {
		try {
			StringBuilder sql = new StringBuilder("from Pessoa");

			Query q = getEntityManager().createQuery(sql.toString());

			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

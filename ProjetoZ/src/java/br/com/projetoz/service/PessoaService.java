package br.com.projetoz.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.projetoz.dao.PessoaDAO;
import br.com.projetoz.entity.Pessoa;
import br.com.projetoz.generic.dao.AbstDAO;
import br.com.projetoz.generic.service.AbstService;

public class PessoaService extends AbstService{

	@Inject
	PessoaDAO pessoaDAO;
	
	public void regraDeNegocioAqui(Pessoa p) {
		//regraDeNegocioAqui
		pessoaDAO.incluir(p);
	}
	
	
	public Collection<Pessoa> regraDeNegocioBuscar(Pessoa p) {
		//regraDeNegocioAqui
		return pessoaDAO.findAll(Pessoa.class);
	}
	
	public Collection<Pessoa> outraRegraDeNegocioEspecificaBuscar(Pessoa p) {
		//regraDeNegocioAqui
		return pessoaDAO.aquiUmaQuerieEspecifica("",null);
	}
	
}

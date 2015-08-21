package br.com.projetoz.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.projetoz.dao.PessoaDAO;
import br.com.projetoz.dao.generic.DAO;
import br.com.projetoz.entity.Pessoa;
import br.com.projetoz.service.generic.Service;

public class PessoaService extends Service{

	@Inject
	PessoaDAO pessoaDAO;
	
	public void regraDeNegocioAqui(Pessoa p) {
		//regraDeNegocioAqui
		pessoaDAO.incluir(p);
	}
	
	
	public Collection<Pessoa> outraRegraDeNegocioBuscar(Pessoa p) {
		//regraDeNegocioAqui
		return pessoaDAO.findAll(Pessoa.class);
	}
	
}

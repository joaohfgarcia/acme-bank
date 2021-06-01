package br.com.bank.dao;

import java.util.List;

import br.com.bank.model.Contato;

public interface ContatoDao {

	void salvar(Contato contato);
	
	List<Contato> list();
	
	void remover(Long id);
	
	void atualizar(Contato contato);
	
	Contato editar(Long id);
}

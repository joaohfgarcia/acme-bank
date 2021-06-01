package br.com.bank.service;

import java.util.List;

import br.com.bank.model.Contato;


public interface ContatoService {
	
	void salvar(Contato contato);
	
	void remover(Long id);
	
	List<Contato> list();
	
	void atualizar(Contato contato);
	
	Contato editar(Long id);

}

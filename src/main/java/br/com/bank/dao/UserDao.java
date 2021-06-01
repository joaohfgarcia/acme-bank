package br.com.bank.dao;

import java.util.List;

import br.com.bank.model.User;

public interface UserDao {

	void salvar(User user);
	
	List<User> list();
	
	void remover(Long id);
	
	void atualizar(User user);
	
	User editar(Long id);

	User buscar(String email,String password);
	
}

package br.com.bank.service;

import java.util.List;

import br.com.bank.dao.UserDaoImpl;
import br.com.bank.model.User;


public class UserServiceImpl implements UserService {
	
	private UserDaoImpl dao;
	
	public UserServiceImpl() {
		this.dao = new UserDaoImpl();
	}

	@Override
	public boolean salvar(User user) {
		if(dao.buscarByEmail(user.getEmail())== null ) {
			this.dao.salvar(user);
			return true;
		}
		else {
			return false;
			
		}
	}
	
	@Override
	public void remover(Long id) {
		this.dao.remover(id);
		
	}

	@Override
	public List<User> list() {
		return this.dao.list();
	}
	
	
	@Override
	public void atualizar(User user) {
		this.dao.atualizar(user);
		
	}
		
	@Override
	public User editar(Long id) {
		return this.dao.editar(id);
		
	}
		
	@Override
	public User buscar(String email,String password)  {
		return this.dao.buscar(email, password);
		
	}
	
	

}

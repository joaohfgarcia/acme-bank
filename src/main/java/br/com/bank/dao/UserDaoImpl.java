package br.com.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.bank.model.User;
import br.com.bank.util.JPAUtil;


public class UserDaoImpl implements UserDao {

	
	@Override
	public void salvar(User user) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			entityManager.close();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public List<User> list() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("SELECT c FROM User c");
		List<User> Users = query.getResultList();
		return Users;
		
	}
	
	@Override
	public void remover(Long id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			User User = entityManager.find(User.class, id);
			
			entityManager.remove(User);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@Override
	public void atualizar(User user) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
			entityManager.merge(user);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}	
	
	
	@Override
	public User editar(Long id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			User user = entityManager.find(User.class, id);
			return user;	
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;	
			
	}

	
	public User buscar(String email,String password) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
			User user = entityManager.createNamedQuery("User.Login",User.class)
					.setParameter("email", email)
					.setParameter("password", password)
					.getSingleResult();
			
			return user;
			
		}catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		
		return null;
	}
	
	public User buscarByEmail(String email) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
			User user = entityManager.createNamedQuery("User.getByEmail",User.class)
					.setParameter("email", email)
					.getSingleResult();
			
			return user;
			
		}catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		
		return null;
	}
	
	
	

}
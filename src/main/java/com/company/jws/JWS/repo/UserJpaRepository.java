package com.company.jws.JWS.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.company.jws.JWS.entity.User;

@Repository
@Transactional
public class UserJpaRepository {

	@PersistenceContext
	EntityManager entityManager;

	public List<User> findAll() {
		TypedQuery<User> q = entityManager.createNamedQuery("user_findall", User.class);
		return q.getResultList();
	}

	public User findById(String id) {
		return entityManager.find(User.class, id);
	}

	public User update(User user) {
		return entityManager.merge(user);
	}

	public User insert(User user) {
		return entityManager.merge(user);
	}

	public boolean deleteById(String id) {
		User user = findById(id);
		if (user == null) {
			return false;
		} else {
			entityManager.remove(user);
			return true;
		}
	}

}

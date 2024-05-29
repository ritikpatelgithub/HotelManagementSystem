package com.java.foodmanagmentsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.foodmanagmentsystem.entity.Admin;
import com.java.foodmanagmentsystem.entity.Hotel;

@Repository
public class AdminDao {

	@Autowired
	EntityManagerFactory emf;

	@Autowired
	EntityManager em;

	@Autowired
	EntityTransaction et;

	public void saveAdmin(Admin admin) {
		et.begin();
		em.persist(admin);
		et.commit();
	}

	public Admin findById(int id) {
		return em.find(Admin.class, id);
	}

	public void updateAdmin(int id) {
		et.begin();
		em.merge(findById(id));
		et.begin();
	}

	public void deleteById(int id) {

		et.begin();
		em.remove(findById(id));
		et.commit();
	}

	public Admin login(String email, String password) {
		Query query = em.createQuery("select a from Admin a where a.email=?1 and a.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			Admin admin = (Admin) query.getSingleResult();
			return admin;
		} catch (Exception e) {
			return null;
		}
	}


}

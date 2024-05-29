package com.java.foodmanagmentsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.foodmanagmentsystem.entity.Hotel;

@Repository
public class HotelDao {
	@Autowired
	EntityManagerFactory emf;

	@Autowired
	EntityManager em;

	@Autowired
	EntityTransaction et;

	public void saveHotel(Hotel hotel) {
		et.begin();
		em.persist(hotel);
		et.commit();
	}

	public Hotel findById(int id) {
		return em.find(Hotel.class, id);
	}

	public void updateHotel(Hotel hotel) {
		et.begin();
		em.merge(hotel);
		et.commit();
	}

	public void deleteById(int id) {
		et.begin();
		em.remove(findById(id));
		et.commit();
	}

	public Hotel login(String email, String password) {
		Query query = em.createQuery("select h from Hotel h where h.email=?1 and h.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			return (Hotel) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	public List<Hotel> findUnapprovedHotels(){
		Query query = em.createQuery("select h from Hotel h where h.status='Not approved'");
		return query.getResultList();
	}
	public List<Hotel> findAllUnblockedHotels() {
		Query query = em.createQuery("select  h from Hotel h where status='approved'");
		List<Hotel> hotels = query.getResultList();
		return hotels;
	}

	public List<Hotel> findAllBlockedHotels() {
		Query query = em.createQuery("select  h from Hotel h where status='Blocked'");
		List<Hotel> hotels = query.getResultList();
		return hotels;
	}
	
	public List<String> findAllHotelName(){
		Query query=em.createQuery("select h.name from Hotel h");
		return query.getResultList();
	}
	
}

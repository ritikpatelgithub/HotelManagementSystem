package com.java.foodmanagmentsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.foodmanagmentsystem.entity.Hotel;
import com.java.foodmanagmentsystem.entity.Item;
import com.java.foodmanagmentsystem.entity.Product;

@Repository
public class ProductDao {
	@Autowired
	EntityManagerFactory emf;

	@Autowired
	EntityManager em;

	@Autowired
	EntityTransaction et;

	public void saveProduct(Product product) {
		et.begin();
		em.persist(product);
		et.commit();
	}

	public Product findById(int id) {
		return em.find(Product.class, id);
	}

	public void updateProduct(Product product) {
		et.begin();
		em.merge(product);
		et.commit();
	}

	public void deleteById(int id) {

		et.begin();
		em.remove(findById(id));
		et.commit();
	}

	public List<Product> findAllProduct() {
		Query query = em.createQuery("select p from Product p");
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	public List<Product> fetchItemByHotel(String hotelName){
		Query query=em.createQuery("select h from Hotel h where h.name=?1");
		query.setParameter(1, hotelName);
		Hotel hotel=(Hotel) query.getSingleResult();
		return hotel.getProducts();
	}
	public List<Product> fetchProductsBetweenPriceRange(double minCost,double maxCost){
		Query query=em.createQuery("select p from Product p where p.cost between ?1 and ?2");
		query.setParameter(1, minCost);
		query.setParameter(2, maxCost);
		
		return query.getResultList();
	}

}

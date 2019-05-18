package com.rs.webscraper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rs.webscraper.entity.Currency;

@Repository
public class CurrencyDaoImpl implements CurrencyDao {
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Currency> getCurrencies() {
		
		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//create query
		Query getCurrencies = session.createQuery("from Currency", Currency.class);
		
		//execute query and add results to list
		List<Currency> theCurrencies = getCurrencies.getResultList();
		
		//return theCurrencies list
		return theCurrencies;
	}
	
	@Override
	public Currency getCurrency(int id) {
		
		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//create query
		return session.get(Currency.class, id);
		
	}

}

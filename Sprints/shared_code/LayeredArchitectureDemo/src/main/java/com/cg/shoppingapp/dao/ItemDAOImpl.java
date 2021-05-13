package com.cg.shoppingapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.shoppingapp.entity.ItemEntity;
import com.cg.shoppingapp.exceptions.ItemNotFoundException;
import com.cg.shoppingapp.service.ItemServiceImpl;

public class ItemDAOImpl implements ItemDAO {

	private static Logger logger = LogManager.getLogger(ItemDAOImpl.class.getName());	
	private static EntityManager entityManager;
	
	static {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ShopCartAppPU");
		entityManager = entityManagerFactory.createEntityManager();
	}
	public ItemEntity findById(int itemId) throws ItemNotFoundException {
		ItemEntity itemEntity = entityManager.find(ItemEntity.class, itemId);
		logger.info("Database returned ItemEntity: " + itemEntity);
		if(itemEntity==null)
			throw new ItemNotFoundException("ItemId: " + itemId);
		return itemEntity;
	}

}

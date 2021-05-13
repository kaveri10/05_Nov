package com.cg.shoppingapp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.shoppingapp.dao.ItemDAO;
import com.cg.shoppingapp.dao.ItemDAOImpl;
import com.cg.shoppingapp.dto.Item;
import com.cg.shoppingapp.entity.ItemEntity;
import com.cg.shoppingapp.exceptions.ItemNotFoundException;
import com.cg.shoppingapp.presentation.ShoppingAppController;
import com.cg.shoppingapp.utils.ShoppingAppUtils;

public class ItemServiceImpl implements ItemService {

	private static Logger logger = LogManager.getLogger(ItemServiceImpl.class.getName());
	ItemDAO itemDao = new ItemDAOImpl();
	
	public Item findById(int itemId) throws ItemNotFoundException {
		ItemEntity itemEntity = itemDao.findById(itemId);
		logger.info("ItemEntity: " + itemEntity);
		return ShoppingAppUtils.convertItemEntityIntoItem(itemEntity);
	}

}

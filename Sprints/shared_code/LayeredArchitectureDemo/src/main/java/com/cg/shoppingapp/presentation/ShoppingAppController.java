package com.cg.shoppingapp.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.shoppingapp.dto.Item;
import com.cg.shoppingapp.exceptions.ItemNotFoundException;
import com.cg.shoppingapp.service.ItemService;
import com.cg.shoppingapp.service.ItemServiceImpl;

public class ShoppingAppController {
	
	private static Logger logger = LogManager.getLogger(ShoppingAppController.class.getName());
	ItemService itemService = new ItemServiceImpl();
	
	public Item findItemById(int itemId) throws ItemNotFoundException {
		logger.info("Finding item for id: " + itemId);
		Item item = null;
		try {
			item = itemService.findById(itemId);
		}
		catch(Exception e) {
			logger.error("ItemNotFoundException: " + e);
			throw new ItemNotFoundException(e.getMessage());
		}
		return item;
	}

}
